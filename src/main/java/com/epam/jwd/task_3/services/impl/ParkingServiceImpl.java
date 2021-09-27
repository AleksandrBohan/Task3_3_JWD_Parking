package com.epam.jwd.task_3.services.impl;


import com.epam.jwd.task_3.controller.ParkingController;
import com.epam.jwd.task_3.repository.impl.ParkingRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.api.ParkingService;
import com.epam.jwd.task_3.services.exchanger.ConsumerForExchange;
import com.epam.jwd.task_3.services.exchanger.ProducerForExchange;
import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Exchanger;




public class ParkingServiceImpl implements ParkingService, Runnable {

    private boolean countOfDelete;

    private static final int PRIORITY_FOR_PRODUCER_THREAD = 10;

    private static final int PRIORITY_FOR_CONSUMER_THREAD = 5;

    private static final int ELEMENT_REMOVAL_RATE = 4;

    private static final Logger logger = LogManager.getLogger(ParkingServiceImpl.class);

    @Override
    public void swapNearbyCars(Car car, Car otherCar) {
        Exchanger<Car> carExchanger = new Exchanger<>();

        Thread producerThread = new Thread(new ProducerForExchange(carExchanger, car));
        Thread consumerThread = new Thread(new ConsumerForExchange(carExchanger, otherCar));

        producerThread.setPriority(PRIORITY_FOR_PRODUCER_THREAD);
        consumerThread.setPriority(PRIORITY_FOR_CONSUMER_THREAD);

        producerThread.start();
        consumerThread.start();
    }

    @Override
    public void fillParkingFromCarList() {
      //  boolean countOfDelete = false;
        boolean fairForBlockingQueue = true;
        CarFactory carFactory = new SedanCarFactory();
        Car car = null;
        ParkingController parkingController = new ParkingController();
        ParkingRepositoryImpl parkingRepository = new ParkingRepositoryImpl();
        List<Car> cars = Collections.synchronizedList(new ArrayList<>());
        int factoryCapacity = 0;
        try {
            factoryCapacity = new CarServiceImpl().fillCarListForParking(carFactory, parkingController.setCarNumber(), cars).size();
        } catch (IllegalStateException exception) {
            logger.error("IllegalStateException in fillParkingFromCarList!" + exception);
        }
        BlockingQueue<Car> parkingPlaces = new ArrayBlockingQueue<Car>(parkingController
                .setParkingPlacesNumber(), fairForBlockingQueue);

        for (int i = 0; i < factoryCapacity; i++) {

            if (i != 0) {
                if ((!(cars.get(i-1).equals(cars.get(i))))) {
                    if ((parkingRepository.addPairOfCars(cars.get(i-1), cars.get(i),
                            parkingPlaces) == true)) {

                        System.out.println(new ParkingRepositoryImpl().isExchangeChecking());
                        if (parkingRepository.isExchangeChecking() == true) {
                            System.out.println("I here!");
                            swapNearbyCars(cars.get(i - 1), car);}

                            if (parkingRepository.isExchangeChecking() == false) {
                                swapNearbyCars(cars.get(i - 1), cars.get(i));

                            }
                        }
                    } else {
                            System.out.println("Exchange isn't availiable!!");

                        }

                        countOfDelete = false;

                        if (i % ELEMENT_REMOVAL_RATE == 0) {
                            new ParkingRepositoryImpl().deleteCar(parkingPlaces);
                            countOfDelete = true;

                        }

                             car = cars.get(i-1);

                    }



                }
            }




    @Override
    public void run() {
        fillParkingFromCarList();

    }

    public boolean isCountOfDelete() {
        return countOfDelete;
    }

    public void setCountOfDelete(boolean countOfDelete) {
        this.countOfDelete = countOfDelete;
    }
}

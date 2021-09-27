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
        boolean countOfDelete = false;
        boolean fairForBlockingQueue = true;
        CarFactory carFactory = new SedanCarFactory();
        Car car = null;
        ParkingController parkingController = new ParkingController();
        List<Car> cars = Collections.synchronizedList(new ArrayList<>());
        int factoryCapacity = 0;
        try {
            factoryCapacity = new CarServiceImpl().fillCarListForParking(carFactory, parkingController.setCarNumber(), cars).size();
        } catch (Exception e) {
            logger.error("IllegalStateException in fillParkingFromCarList!");
        }
        BlockingQueue<Car> parkingPlaces = new ArrayBlockingQueue<Car>(parkingController
                .setParkingPlacesNumber(), fairForBlockingQueue);

        for (int j = 0; j < factoryCapacity; j++) {
            for (int i = 0; i < factoryCapacity; i++) {
                if ((!(cars.get(i).equals(cars.get(j))))) {
                    if ((new ParkingRepositoryImpl().addPairOfCars(cars.get(i), cars.get(j),
                            parkingPlaces) == true)) {
                        if (countOfDelete == true){
                            swapNearbyCars(cars.get(j), car);

                        } else if (countOfDelete == false){
                            swapNearbyCars(cars.get(i), cars.get(j));

                        }

                        countOfDelete = false;

                        if (i % ELEMENT_REMOVAL_RATE == 0) {
                            new ParkingRepositoryImpl().deleteCar(parkingPlaces);
                            countOfDelete = true;
                            car = cars.get(i);

                        }
                    } else {
                        System.out.println("Exchange isn't availiable!!");

                    }

                }
            }
        }
    }

    @Override
    public void run() {
        fillParkingFromCarList();

    }

}

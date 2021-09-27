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

    private static final int ELEMENT_REMOVAL_RATE = 3;

    private static final Logger logger = LogManager.getLogger(ParkingServiceImpl.class);

    public static int getPriorityForProducerThread() {
        return PRIORITY_FOR_PRODUCER_THREAD;
    }

    public static int getPriorityForConsumerThread() {
        return PRIORITY_FOR_CONSUMER_THREAD;
    }

    public static int getElementRemovalRate() {
        return ELEMENT_REMOVAL_RATE;
    }

    public static Logger getLogger() {
        return logger;
    }

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
            logger.error("IllegalStateException in fillParkingFromCarList() method!" + exception);
        }
        BlockingQueue<Car> parkingPlaces = new ArrayBlockingQueue<Car>(parkingController
                .setParkingPlacesNumber(), fairForBlockingQueue);

        for (int i = 0; i < factoryCapacity; i++) {

            if (i != 0) {
                if ((!(cars.get(i - 1).equals(cars.get(i))))) {
                    if ((parkingRepository.addPairOfCars(cars.get(i - 1), cars.get(i),
                            parkingPlaces) == true)) {

                        if (parkingRepository.isExchangeChecking() == true) {
                            swapNearbyCars(cars.get(i - 1), car);

                        }

                        if (parkingRepository.isExchangeChecking() == false) {
                            swapNearbyCars(cars.get(i - 1), cars.get(i));

                        }

                        car = cars.get(i - 1);

                    } else {
                        logger.info("Exchange isn't availiable!!");

                    }

                    if (i % ELEMENT_REMOVAL_RATE == 0) {
                        new ParkingRepositoryImpl().deleteCar(parkingPlaces);

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

package com.epam.jwd.task_3.services.impl;


import com.epam.jwd.task_3.controller.ParkingController;
import com.epam.jwd.task_3.repository.impl.ParkingRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.api.ParkingService;
import com.epam.jwd.task_3.services.exchanger.ConsumerForExchange;
import com.epam.jwd.task_3.services.exchanger.ProducerForExchange;
import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Exchanger;




public class ParkingServiceImpl implements ParkingService, Runnable {

    private static final int PRIORITY_FOR_PRODUCER_THREAD = 10;

    private static final int PRIORITY_FOR_CONSUMER_THREAD = 5;

    private static final int ELEMENT_REMOVAL_RATE = 6;

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
        int countOfDelete = 0;
        CarFactory carFactory = new SedanCarFactory();
        Car car = null;
        ParkingController parkingController = new ParkingController();
        List<Car> cars = Collections.synchronizedList(new ArrayList<>());
        int factoryCapacity = new CarServiceImpl().fillCarListForParking(carFactory, parkingController
                .setCarNumber(), cars).size();
        BlockingQueue<Car> parkingPlaces = new ArrayBlockingQueue<Car>(parkingController
                .setParkingPlacesNumber(), true);

        for (int j = 0; j < factoryCapacity; j++) {
            for (int i = 0; i < factoryCapacity; i++) {
                if ((!(cars.get(i).equals(cars.get(j))))) {
                        if ((new ParkingRepositoryImpl().addPairOfCars(cars.get(i), cars.get(j),
                                parkingPlaces) == true)) {
                                if (countOfDelete == 1){
                                    swapNearbyCars(cars.get(j), car);

                                } else if (countOfDelete == 0){
                                    swapNearbyCars(cars.get(i), cars.get(j));

                                }
                            if (i % ELEMENT_REMOVAL_RATE == 0) {
                                new ParkingRepositoryImpl().deleteCar(parkingPlaces);
                                countOfDelete = 1;
                                car = cars.get(i);

                            }
                        } else {
                            System.out.println("Exchange isn't availiable!!");

                        }

                        countOfDelete = 0;

                    }
                }
            }
        }

    @Override
    public void run() {
        fillParkingFromCarList();

    }

}

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

    private int countOfCars;
    private int countOfParkingPlaces;
    private static final int PRIORITY_FOR_PRODUCER_THREAD = 10;
    private static final int PRIORITY_FOR_CONSUMER_THREAD = 5;
   /* BlockingQueue<Car> parkingPlaces;
    CarFactory carFactory = new SedanCarFactory();
    List<Car> cars = Collections.synchronizedList(new ArrayList<>());*/



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


        boolean deleteStatement = true;
        int numberForExchange = 1;
        CarFactory carFactory = new SedanCarFactory();
        List<Car> cars = Collections.synchronizedList(new ArrayList<>());
    //TODO delete it!!    Exchanger<Car> carExchanger = new Exchanger<>();
        BlockingQueue<Car> parkingPlaces = new ArrayBlockingQueue<Car>(new ParkingController().setParkingPlacesNumber(), true);

        int factoryCapacity = new CarServiceImpl().fillCarListForParking(carFactory, new ParkingController().setCarNumber(), cars).size();
        Car car = null;
        int countOfDelete = 0;
        for (int j = 0; j < factoryCapacity; j++) {
            for (int i = 0; i < factoryCapacity; i++) {
                if ((!(cars.get(i).equals(cars.get(j)))))
                        {

                        if ((new ParkingRepositoryImpl().addPairOfCars(cars.get(i), cars.get(j), parkingPlaces,
                                numberForExchange) == true)) {
                                if (countOfDelete == 1){
                                    swapNearbyCars(cars.get(j), car);
                                } else if (countOfDelete == 0){
                                    swapNearbyCars(cars.get(i), cars.get(j));
                                }
                            if (i % 6 == 0) {
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



    public int getCountOfCars() {
        return countOfCars;
    }

    public void setCountOfCars(int countOfCars) {
        this.countOfCars = countOfCars;
    }


    public int getCountOfParkingPlaces() {
        return countOfParkingPlaces;
    }

    public void setCountOfParkingPlaces(int countOfParkingPlaces) {
        this.countOfParkingPlaces = countOfParkingPlaces;
    }

    @Override
    public void run() {
        fillParkingFromCarList();
    }


}

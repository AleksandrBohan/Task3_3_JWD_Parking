package com.epam.jwd.task_3.services.impl;

import com.epam.jwd.task_3.repository.impl.CarRepositoryImpl;
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

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Exchanger;



public class ParkingServiceImpl implements ParkingService{

    private int countOfCars;

    private static final int SIZE_OF_PARKING_TIME = 3;
    private BlockingQueue<Car> parkingPlaces;
    CarFactory carFactory = new SedanCarFactory();
    List<Car> cars = Collections.synchronizedList(new ArrayList<>());
    Scanner scanner = new Scanner(System.in);
    boolean flagOfFair;
    boolean carOnParking;
    private Exchanger<Car> exchanger = new Exchanger<>();

    private Exchanger<Car> carExchanger = new Exchanger<>();
    List<Car> carStorage;

    @Override
    public void swapNearbyCars(Car car, Car otherCar) {
        new Thread(new ProducerForExchange(carExchanger, car)).start();
        new Thread(new ConsumerForExchange(carExchanger, otherCar)).start();
    }

    public void fillParkingFromCarList() {
        int numberForExchange = 1;
        flagOfFair = true;
        parkingPlaces = new ArrayBlockingQueue<Car>(5, flagOfFair);
        int factoryCapacity = new CarServiceImpl().fillCarListForParking(carFactory, 5, cars).size();
        for (int j = 0; j < factoryCapacity; j++) {
            for (int i = 0; i < factoryCapacity; i++) {
                if (cars.get(i) != cars.get(j)) {
                    carOnParking = new ParkingRepositoryImpl().addPairOfCars(cars.get(i), cars.get(j), parkingPlaces,
                            numberForExchange);
                    if (numberForExchange == 1 & carOnParking == true) {

                        System.out.println(cars.get(i));
                        System.out.println(cars.get(j));

                        Thread consumerExchengerThread = new Thread(new ConsumerForExchange(exchanger, cars.get(i)));
                        Thread producerExchengerThread = new Thread(new ProducerForExchange(exchanger, cars.get(j)));

                        producerExchengerThread.setPriority(10);
                        consumerExchengerThread.setPriority(9);
                        System.out.println("\n" + "\n" + "\n");
                        producerExchengerThread.start();
                        System.out.println();
                        consumerExchengerThread.start();
                        System.out.println("\n" + "\n" + "\n");

                    }
                    if (i % 4 == 0) {
                        flagOfFair = false;
                        new ParkingRepositoryImpl().deleteCar(parkingPlaces);
                    }


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


    public Exchanger<Car> getCarExchanger() {
        return carExchanger;
    }

    public void setCarExchanger(Exchanger<Car> carExchanger) {
        this.carExchanger = carExchanger;
    }
}

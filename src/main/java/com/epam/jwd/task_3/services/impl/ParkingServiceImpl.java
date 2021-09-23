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
import java.util.concurrent.TimeUnit;


public class ParkingServiceImpl implements ParkingService{

    private int countOfCars;

    private static final int SIZE_OF_PARKING_TIME = 3;
    private BlockingQueue<Car> parkingPlaces;
    CarFactory carFactory = new SedanCarFactory();
    List<Car> cars = Collections.synchronizedList(new ArrayList<>());
    Scanner scanner = new Scanner(System.in);
    boolean flagOfFair;
    boolean carOnParking;

    private Exchanger<Car> carExchanger = new Exchanger<>();
    List<Car> carStorage;

    @Override
    public void swapNearbyCars(Car car, Car otherCar) {
        new Thread(new ProducerForExchange(carExchanger, car)).start();
        new Thread(new ConsumerForExchange(carExchanger, otherCar)).start();
    }

    public void fillParkingFromCarList() {

        flagOfFair = true;
        parkingPlaces = new ArrayBlockingQueue<Car>(1, flagOfFair);
        int factoryCapacity = new CarServiceImpl().fillCarListForParking(carFactory, 5, cars).size();

        for (int i = 0; i < factoryCapacity; i++) {
            new ParkingRepositoryImpl().addCar(cars.get(i), parkingPlaces);
            if (i % 4 == 0) {
                flagOfFair = false;
                new ParkingRepositoryImpl().deleteCar(parkingPlaces);
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

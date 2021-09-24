package com.epam.jwd.task_3.repository.impl;


import com.epam.jwd.task_3.repository.api.ParkingRepository;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;

import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;




public class ParkingRepositoryImpl implements ParkingRepository {

    private static final int SIZE_OF_PARKING_TIME = 3;
    private BlockingQueue<Car> parkingPlaces;
    CarFactory carFactory = new SedanCarFactory();
    List<Car> cars = Collections.synchronizedList(new ArrayList<>());
    Scanner scanner = new Scanner(System.in);
    boolean carOnParking;
    boolean addCarFirst;
    boolean addCarSecond;

    @Override
    public boolean addPairOfCars(Car firstCar, Car secondCar, BlockingQueue<Car> parkingPlaces, int numberForExchange) {
        try {
            addCarFirst = parkingPlaces.offer(firstCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS);
            addCarSecond = parkingPlaces.offer(secondCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS);
            System.out.println("-----------------------------------------");
            System.out.println("Car1 is trying to park: " + firstCar.toString());
            System.out.println("Car2 is trying to park: " + secondCar.toString());
            System.out.println("-----------------------------------------");
            if (addCarFirst = true){
                carOnParking = true;
                System.out.println("-----------------------------------------------------");
                System.out.println(firstCar.toString() + "\n" + " was parked!!");
                System.out.println("-----------------------------------------------------");
                if (addCarSecond = true){
                    System.out.println("-----------------------------------------------------");
                    System.out.println(secondCar.toString() + "\n" + " was parked!!");
                    System.out.println("-----------------------------------------------------");
                    carOnParking = true;
                    return carOnParking;
                } else if (addCarSecond = false){
                    carOnParking = false;
                    System.out.println("-----------------------------------------------------");
                    System.out.println(secondCar.toString() + "\n" + " couldn't park!!");
                    System.out.println("-----------------------------------------------------");
                    return carOnParking;
                }
                return carOnParking;
            } else if (addCarFirst = false){
                carOnParking = false;
                System.out.println("-----------------------------------------------------");
                System.out.println(firstCar.toString() + "\n" + " couldn't park!!");
                System.out.println("-----------------------------------------------------");
                return carOnParking;

            }

        } catch (InterruptedException exception) {
        exception.printStackTrace();
    }

        return carOnParking;
    }

    @Override
    public void deleteCar(BlockingQueue<Car> parkingPlaces) {
        try {
            System.out.println("--------------------------------------");
            System.out.println("Car was deleted" + parkingPlaces.take());
            System.out.println("--------------------------------------");

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}

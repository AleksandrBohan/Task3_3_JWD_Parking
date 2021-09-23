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
    boolean flagOfFair;

    @Override
    public void addCar(Car car, BlockingQueue<Car> parkingPlaces) {
        try {
            System.out.println("-----------------------------------------");
            System.out.println("Car is trying to park: " + car.toString());
            System.out.println("-----------------------------------------");
            if (parkingPlaces.offer(car, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS) == true){
                System.out.println("-----------------------------------------------------");
                System.out.println(car.toString() + "\n" + " was parked!!");
                System.out.println("-----------------------------------------------------");
            } else {
                System.out.println("-----------------------------------------------------");
                System.out.println(car.toString() + "\n" + " couldn't park!!");
                System.out.println("-----------------------------------------------------");
            }
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
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

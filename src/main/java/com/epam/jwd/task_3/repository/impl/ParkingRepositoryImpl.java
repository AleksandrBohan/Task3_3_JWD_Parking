package com.epam.jwd.task_3.repository.impl;


import com.epam.jwd.task_3.repository.api.ParkingRepository;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;

import com.epam.jwd.task_3.services.exchanger.ConsumerForExchange;
import com.epam.jwd.task_3.services.exchanger.ProducerForExchange;
import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Exchanger;
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
    private Exchanger<Car> exchanger = new Exchanger<>();

    @Override
    public boolean addPairOfCars(Car firstCar, BlockingQueue<Car> parkingPlaces, int numberForExchange) {
        try {
           // parkingPlaces.offer(firstCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS);

            System.out.println("-----------------------------------------");
            System.out.println("Car1 is trying to park: " + firstCar.toString());
            System.out.println("-----------------------------------------");
            if (parkingPlaces.offer(firstCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS) == true){
                carOnParking = true;
                System.out.println("-----------------------------------------------------");
                System.out.println(firstCar.toString() + "\n" + " was parked!!");
                System.out.println("-----------------------------------------------------");
                return carOnParking;
            } else if (parkingPlaces.offer(firstCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS) == false){
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

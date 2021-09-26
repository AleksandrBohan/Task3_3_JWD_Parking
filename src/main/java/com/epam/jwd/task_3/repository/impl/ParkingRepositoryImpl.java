package com.epam.jwd.task_3.repository.impl;

import com.epam.jwd.task_3.repository.api.ParkingRepository;
import com.epam.jwd.task_3.repository.model.Car;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;




public class ParkingRepositoryImpl implements ParkingRepository {

    private static final int SIZE_OF_PARKING_TIME = 3;

    boolean carOnParkingFirst;

    @Override
    public boolean addPairOfCars(Car firstCar, Car secondCar, BlockingQueue<Car> parkingPlaces) {
        try {

            System.out.println("-----------------------------------------");
            System.out.println("Car1 is trying to park: " + firstCar.toString());
            System.out.println("Car2 is trying to park: " + secondCar.toString());
            System.out.println("-----------------------------------------");

            if (parkingPlaces.offer(firstCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS) == true){
                carOnParkingFirst = true;
                System.out.println("-----------------------------------------------------");
                System.out.println(firstCar.toString() + "\n" + " was parked!!");
                System.out.println("-----------------------------------------------------");

                if (parkingPlaces.offer(secondCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS) == true) {
                    System.out.println("-----------------------------------------------------");
                    System.out.println(secondCar.toString() + "\n" + " was parked!!");
                    System.out.println("-----------------------------------------------------");

                } else if (parkingPlaces.offer(secondCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS) == false) {
                    System.out.println("-----------------------------------------------------");
                    System.out.println(secondCar.toString() + "\n" + " couldn't park!!");
                    System.out.println("-----------------------------------------------------");

                }

                return carOnParkingFirst;

            } else if (parkingPlaces.offer(firstCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS) == false){
               carOnParkingFirst = false;
                System.out.println("-----------------------------------------------------");
                System.out.println(firstCar.toString() + "\n" + " couldn't park!!");
                System.out.println("-----------------------------------------------------");
                return carOnParkingFirst;

            }

        } catch (InterruptedException exception) {
        exception.printStackTrace();

    }

        return carOnParkingFirst;

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

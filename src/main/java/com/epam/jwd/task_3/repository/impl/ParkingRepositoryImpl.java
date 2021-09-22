package com.epam.jwd.task_3.repository.impl;


import com.epam.jwd.task_3.repository.api.ParkingRepository;
import com.epam.jwd.task_3.repository.model.Car;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ParkingRepositoryImpl implements ParkingRepository {

    private static final int SIZE_OF_PARKING_TIME = 3;
    private BlockingQueue<Car> parkingPlaces;

    @Override
    public void addCar(Car car, BlockingQueue<Car> parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
        parkingPlaces = new ArrayBlockingQueue<Car>(1, false);
        try {
            boolean parkingCar = parkingPlaces.offer(car, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS);
            System.out.println("Car is trying to park: " + car + "  " + parkingCar);

                if (!parkingCar) {
                    System.out.println("Parking was failed! Sleep sometime!");
                }
                else  {
                    System.out.println("success!! Car was parked!");
                }

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteCar() {
        try {
            System.out.println("Car was deleted" + parkingPlaces.take());

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}

package com.epam.jwd.task_3.repository.impl;

import com.epam.jwd.task_3.repository.api.ParkingRepository;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.Parking;

import java.util.concurrent.TimeUnit;




public class ParkingRepositoryImpl implements ParkingRepository {

    private static final int SIZE_OF_PARKING = 3;

    @Override
    public void addCar(Car car) {
        try {
            new Parking().getParkingPlaces().offer(car, SIZE_OF_PARKING, TimeUnit.SECONDS);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteCar() {
        try {
            new Parking().getParkingPlaces().take();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}

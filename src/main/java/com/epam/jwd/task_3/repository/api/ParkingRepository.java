package com.epam.jwd.task_3.repository.api;

import com.epam.jwd.task_3.repository.model.Car;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public interface ParkingRepository {

    void addCar(Car car, BlockingQueue<Car> parkingPlaces);

    void deleteCar();

}

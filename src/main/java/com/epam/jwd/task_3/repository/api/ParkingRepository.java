package com.epam.jwd.task_3.repository.api;

import com.epam.jwd.task_3.repository.model.Car;

import java.util.concurrent.BlockingQueue;




public interface ParkingRepository {

    boolean addPairOfCars(Car firstCar, Car secondCar, BlockingQueue<Car> parkingPlaces);

    void deleteCar(BlockingQueue<Car> parkingPlaces);

}

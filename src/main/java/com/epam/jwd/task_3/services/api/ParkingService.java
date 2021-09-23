package com.epam.jwd.task_3.services.api;

import com.epam.jwd.task_3.repository.model.Car;

import java.util.List;


public interface ParkingService {

    void swapNearbyCars(Car car, Car otherCar);
    void fillCarListForParking(CarFactory factory, int countOfCars);

    List<Car> fillCarListForParking(CarFactory factory, int countOfCars, List<Car> carStorage);
}

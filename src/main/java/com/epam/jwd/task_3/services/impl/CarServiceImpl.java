package com.epam.jwd.task_3.services.impl;

import com.epam.jwd.task_3.repository.impl.CarRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.api.CarService;

import java.util.List;


public class CarServiceImpl implements CarService {

    private int countOfCars;

    @Override
    public List<Car> fillCarListForParking(CarFactory factory, int countOfCars, List<Car> carStorage) {

        this.countOfCars = countOfCars;

        for (int i = 0; i < countOfCars; i++){

            new CarRepositoryImpl().save(factory.getMercedesCar(), carStorage);
            System.out.println(carStorage.get(0));

            new CarRepositoryImpl().save(factory.getToyotaCar(), carStorage);
            System.out.println(carStorage.get(1));

            new CarRepositoryImpl().save(factory.getOpelCar(), carStorage);
            System.out.println(carStorage.get(2));

            new CarRepositoryImpl().save(factory.getVolkswagenCar(), carStorage);
            System.out.println(carStorage.get(3));

            new CarRepositoryImpl().save(factory.getRenaultCar(), carStorage);
            System.out.println(carStorage.get(4));


        }

        return carStorage;
    }
}

package com.epam.jwd.task_3.services.impl;

import com.epam.jwd.task_3.repository.impl.CarRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.api.CarService;

import java.util.List;


public class CarServiceImpl implements CarService {

    @Override
    public List<Car> fillCarListForParking(CarFactory factory, int countOfCars, List<Car> carStorage) {

        for (int i = 0; i < countOfCars; i++){
            new CarRepositoryImpl().save(factory.getMercedesCar(), carStorage);

            new CarRepositoryImpl().save(factory.getToyotaCar(), carStorage);

            new CarRepositoryImpl().save(factory.getOpelCar(), carStorage);

            new CarRepositoryImpl().save(factory.getVolkswagenCar(), carStorage);

            new CarRepositoryImpl().save(factory.getRenaultCar(), carStorage);

        }

        return carStorage;

    }

}

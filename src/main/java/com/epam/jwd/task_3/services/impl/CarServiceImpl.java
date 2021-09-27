package com.epam.jwd.task_3.services.impl;

import com.epam.jwd.task_3.repository.impl.CarRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.api.CarService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


public class CarServiceImpl implements CarService {

    private static final Logger logger = LogManager.getLogger(CarServiceImpl.class);

    @Override
    public List<Car> fillCarListForParking(CarFactory factory, int countOfCars, List<Car> carStorage) {

        for (int i = 0; i < countOfCars; i++){
            logger.info("Cars list: \n");
            new CarRepositoryImpl().save(factory.getMercedesCar(), carStorage);
            logger.debug(carStorage.get(0));

            new CarRepositoryImpl().save(factory.getToyotaCar(), carStorage);
            logger.debug(carStorage.get(1));

            new CarRepositoryImpl().save(factory.getOpelCar(), carStorage);
            logger.debug(carStorage.get(2));

            new CarRepositoryImpl().save(factory.getVolkswagenCar(), carStorage);
            logger.debug(carStorage.get(3));

            new CarRepositoryImpl().save(factory.getRenaultCar(), carStorage);
            logger.debug(carStorage.get(4));

        }

        return carStorage;

    }

}

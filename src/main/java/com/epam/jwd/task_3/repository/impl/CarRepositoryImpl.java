package com.epam.jwd.task_3.repository.impl;

import com.epam.jwd.task_3.controller.ParkingController;
import com.epam.jwd.task_3.repository.api.CarRepository;
import com.epam.jwd.task_3.repository.model.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;




public class CarRepositoryImpl implements CarRepository {

    @Override
    public void save(Car car, List<Car> carStorage) {
            carStorage.add(car);

    }

}

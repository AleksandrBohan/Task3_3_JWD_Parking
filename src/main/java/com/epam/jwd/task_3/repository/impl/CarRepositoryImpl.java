package com.epam.jwd.task_3.repository.impl;

import com.epam.jwd.task_3.repository.api.CarRepository;
import com.epam.jwd.task_3.repository.model.Car;

import java.util.List;




public class CarRepositoryImpl implements CarRepository {

    @Override
    public void save(Car car, List<Car> carStorage) {
            carStorage.add(car);

    }

}

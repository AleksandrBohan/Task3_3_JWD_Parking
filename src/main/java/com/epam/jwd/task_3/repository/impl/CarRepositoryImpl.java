package com.epam.jwd.task_3.repository.impl;

import com.epam.jwd.task_3.repository.api.CarRepository;
import com.epam.jwd.task_3.repository.model.Car;

import java.util.List;




public class CarRepositoryImpl implements CarRepository {

    @Override
    public void save(Car car, List<Car> carStorage) {
        try {
            carStorage.add(car);

        }
        catch (Exception exception){
           //TODO write exception for it!!!
        }
    }

}

package com.epam.jwd.task_3.repository.impl;

import com.epam.jwd.task_3.repository.api.CarRepository;
import com.epam.jwd.task_3.repository.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    private CarRepositoryImpl instance;

    private List <Car> carStorage = new ArrayList<>();


    @Override
    public void save(Car car) {
        try{
            carStorage.add(car);
        }
        catch (Exception exception){
           //TODO write exception for it!!!
        }
    }

    @Override
    public Car findById(Long id) {

        return carStorage.stream()
                .filter(car -> id.equals(car.getPersonalNumberOfCar()))
                .findFirst()
                .orElse(null);
    }


    @Override
    public boolean delete(Car car) {
        return carStorage.remove(car);
    }



    public void setInstance(CarRepositoryImpl instance) {
        this.instance = instance;
    }
}

package com.epam.jwd.task_3.repository.impl;

import com.epam.jwd.task_3.repository.api.CarRepository;
import com.epam.jwd.task_3.repository.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarRepositoryImpl implements CarRepository {

    private Lock lock = new ReentrantLock();

    private List <Car> carStorage = new ArrayList<>();


    @Override
    public void save(Car car, List<Car> carStorage) {
        setCarStorage(carStorage);
        try{
            lock.lock();
            carStorage.add(car);
            lock.unlock();
        }
        catch (Exception exception){
           //TODO write exception for it!!!
        }
    }

    @Override
    public Car findByPersonalNumberOfCar(Long personalNumber) {
        return carStorage.stream()
                .filter(car -> personalNumber.equals(car.getPersonalNumberOfCar()))
                .findFirst()
                .orElse(null);

    }

    @Override
    public boolean delete(Car car) {
        return carStorage.remove(car);
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public List<Car> getCarStorage() {
        return carStorage;
    }

    public void setCarStorage(List<Car> carStorage) {
        this.carStorage = carStorage;
    }
}

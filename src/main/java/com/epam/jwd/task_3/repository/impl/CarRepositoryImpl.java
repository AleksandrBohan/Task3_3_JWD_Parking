package com.epam.jwd.task_3.repository.impl;

import com.epam.jwd.task_3.repository.api.CarRepository;
import com.epam.jwd.task_3.repository.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarRepositoryImpl implements CarRepository {

    private int countOfCars;

    private Lock lock = new ReentrantLock();

    private List <Car> carStorage = Collections.synchronizedList(new ArrayList<>()); /// easy ArrayList

    BlockingQueue<Car> queue = new ArrayBlockingQueue<Car>(1, false);


    @Override
    public void save(Car car, List<Car> carStorage) {
        setCarStorage(carStorage);
        try{
            carStorage.add(car);
        }
        catch (Exception exception){
           //TODO write exception for it!!!
        }
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

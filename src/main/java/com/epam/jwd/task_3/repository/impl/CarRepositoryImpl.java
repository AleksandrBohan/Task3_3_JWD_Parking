package com.epam.jwd.task_3.repository.impl;

import com.epam.jwd.task_3.repository.api.CarRepository;
import com.epam.jwd.task_3.repository.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarRepositoryImpl implements CarRepository, Runnable {

    private int countOfCars;

    private Lock lock = new ReentrantLock();

    private List <Car> carStorage = Collections.synchronizedList(new ArrayList<>());


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
    public void getCarsAndFillParking(List<Car> cars, int countOfCars) {
        lock.lock();
        this.countOfCars = countOfCars;
        countOfCars *= 5;
       for (int i = 0; i < countOfCars; i++){
            new ParkingRepositoryImpl().addCar(cars.get(i));
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

    @Override
    public void run() {
        List <Car> carStorage = Collections.synchronizedList(new ArrayList<>());
        lock.lock();
        countOfCars = 5;
        for (int i = 0; i < countOfCars; i++){
            new ParkingRepositoryImpl().addCar(carStorage.get(i));
        }
    }
}

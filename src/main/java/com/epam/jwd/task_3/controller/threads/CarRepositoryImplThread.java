package com.epam.jwd.task_3.controller.threads;

import com.epam.jwd.task_3.controller.ParkingController;
import com.epam.jwd.task_3.repository.impl.ParkingRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CarRepositoryImplThread implements Runnable {

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        List<Car> carStorage = new ParkingController().getCars();
        lock.lock();
        int countOfCars = new ParkingController().getCountOfCars();
        countOfCars *= 5;
        for (int i = 0; i < countOfCars; i++) {
            new ParkingRepositoryImpl().addCar(carStorage.get(i));
        }
        lock.unlock();
    }
}

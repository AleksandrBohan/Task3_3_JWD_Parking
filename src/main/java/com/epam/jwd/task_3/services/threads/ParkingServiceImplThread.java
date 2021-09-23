package com.epam.jwd.task_3.services.threads;


import com.epam.jwd.task_3.controller.ParkingController;
import com.epam.jwd.task_3.repository.impl.CarRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.impl.ParkingServiceImpl;
import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ParkingServiceImplThread implements Runnable {

    private int countOfCars;

    private CarFactory factory = new SedanCarFactory();

    private List<Car> carStorage;



    @Override
    public void run() {

        //new ParkingServiceImpl().fillCarListForParking(factory, 5, carStorage);

       // new CarRepositoryImpl().getCarsAndFillParking(carStorage, 5);

        }

    public int getCountOfCars() {
        return countOfCars;
    }

    public void setCountOfCars(int countOfCars) {
        this.countOfCars = countOfCars;
    }
}


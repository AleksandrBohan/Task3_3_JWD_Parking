package com.epam.jwd.task_3.controller;


import com.epam.jwd.task_3.services.impl.ParkingServiceImpl;

import com.epam.jwd.task_3.repository.model.Car;

import java.util.List;

public class ParkingController {
    private int countOfCars;

    private List<Car> cars;


    public static void main(String[] args) {
        Thread thread = new Thread(new ParkingServiceImpl());
        thread.setPriority(1);
        thread.start();


    }


    public int getCountOfCars() {
        return countOfCars;
    }

    public void setCountOfCars(int countOfCars) {
        this.countOfCars = countOfCars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}

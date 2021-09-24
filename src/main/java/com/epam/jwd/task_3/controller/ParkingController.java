package com.epam.jwd.task_3.controller;


import com.epam.jwd.task_3.services.threads.ParkingServiceThread;
import com.epam.jwd.task_3.repository.model.Car;

import java.util.List;

public class ParkingController {
    private int countOfCars;

    private List<Car> cars;


    public static void main(String[] args) {
        Thread thread = new Thread(new ParkingServiceThread());
        thread.setPriority(8);
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

package com.epam.jwd.task_3.controller;

import com.epam.jwd.task_3.repository.impl.ParkingRepositoryImpl;
import com.epam.jwd.task_3.services.threads.ParkingRepositiryImplProducer;
import com.epam.jwd.task_3.services.threads.ParkingServiceImplThread;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ParkingController {
    private int countOfCars;

    private List<Car> cars;


    public static void main(String[] args) {
        Thread thread = new Thread(new ParkingRepositiryImplProducer());
        thread.start();
        System.out.println(thread.isAlive());

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

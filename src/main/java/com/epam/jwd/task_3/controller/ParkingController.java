package com.epam.jwd.task_3.controller;

import com.epam.jwd.task_3.controller.threads.ParkingServiceImplThread;
import com.epam.jwd.task_3.repository.impl.CarRepositoryImpl;
import com.epam.jwd.task_3.repository.impl.ParkingRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.impl.ParkingServiceImpl;
import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ParkingController {
    private int countOfCars;

    private List<Car> cars;


    public static void main(String[] args) {

        CarFactory carFactory = null;
        new ParkingController().setCars(Collections.synchronizedList(new ArrayList<>()));

        Scanner scanner = new Scanner(System.in);
        //How many cars do you want to create 1 - 5 cars, 2 - 10 cars;

        new ParkingController().setCountOfCars(scanner.nextInt());
        new Thread(new ParkingServiceImplThread()).start();
        System.out.println("--------------------------------------------------");
        //What cars do you want to get: 1 - sedan, 2 - hatchback, 3 - minivan;
        int typeOfCars = scanner.nextInt();

        if (typeOfCars == 1) {

        }

        new Thread(new ParkingRepositoryImpl()).start();
        new Thread(new CarRepositoryImpl()).start();

       // ParkingServiceImpl parkingService = new ParkingServiceImpl();

       /* new CarRepositoryImpl().getCarsAndFillParking(parkingService
                .fillCarListForParking(carFactory, countOfCars), countOfCars);*/

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

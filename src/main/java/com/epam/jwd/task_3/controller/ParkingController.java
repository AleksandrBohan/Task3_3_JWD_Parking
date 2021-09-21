package com.epam.jwd.task_3.controller;

import com.epam.jwd.task_3.repository.impl.CarRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.impl.ParkingServiceImpl;
import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ParkingController {


    public static void main(String[] args) {
        CarFactory carFactory = null;
        List<Car> cars = Collections.synchronizedList(new ArrayList<>());

        Scanner scanner = new Scanner(System.in);
        //How many cars do you want to create 1 - 5 cars, 2 - 10 cars;
        int countOfCars = scanner.nextInt();
        System.out.println("--------------------------------------------------");
        //What cars do you want to get: 1 - sedan, 2 - hatchback, 3 - minivan;
        int typeOfCars = scanner.nextInt();

        if (typeOfCars == 1) {
            carFactory = new SedanCarFactory();
        }

        ParkingServiceImpl parkingService = new ParkingServiceImpl();

        new CarRepositoryImpl().getCarsAndFillParking(parkingService
                .fillCarListForParking(carFactory, countOfCars), countOfCars);

    }
}

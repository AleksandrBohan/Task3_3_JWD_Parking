package com.epam.jwd.task_3.controller;

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

        Scanner scanner = new Scanner(System.in);
        //How many cars do you want to create 1 - 5 cars, 2 - 10 cars;
        int countOfCars = scanner.nextInt();

        new ParkingServiceImplThread().setCountOfCars(countOfCars);

        System.out.println("--------------------------------------------------");
        //What cars do you want to get: 1 - sedan, 2 - hatchback, 3 - minivan;
        int typeOfCars = scanner.nextInt();

        if (typeOfCars == 1) {

            new Thread(new ParkingServiceImplThread()).start();

        }



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

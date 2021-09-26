package com.epam.jwd.task_3.controller;


import com.epam.jwd.task_3.services.impl.ParkingServiceImpl;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.view.ParkingView;

import java.util.List;
import java.util.Scanner;

public class ParkingController {

    private List<Car> cars;

    public static void main(String[] args) {

        Thread thread = new Thread(new ParkingServiceImpl());
        thread.setPriority(1);
        thread.start();
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int setCarNumber(){
        ParkingView carsView = new ParkingView();
        Scanner carsScanner = new Scanner(System.in);

        carsView.getCountOfCars();

        String countOfCars = carsScanner.nextLine();

        int carsNumber;

        switch (countOfCars) {

            case "1":
                carsNumber = 1;
                break;

            case "2":
                carsNumber = 2;
                break;

            case "3":
                carsNumber = 3;
                break;

            case "4":
                carsNumber = 4;
                break;

            case "5":
                carsNumber = 5;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + countOfCars);

        }

        return carsNumber;

    }

   public int setParkingPlacesNumber(){
        ParkingView parkingView = new ParkingView();
        Scanner parkingScanner = new Scanner(System.in);

        parkingView.getCountOfParkingPlaces();

        String countOfParkingPlaces = parkingScanner.nextLine();

        int parkingPlacesNumber;

        switch (countOfParkingPlaces) {

            case "1":
                parkingPlacesNumber = 5;
                break;

            case "2":
                parkingPlacesNumber = 10;
                break;

            case "3":
                parkingPlacesNumber = 15;
                break;

            case "4":
                parkingPlacesNumber = 20;
                break;

            case "5":
                parkingPlacesNumber = 25;
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + countOfParkingPlaces);

        }

        return parkingPlacesNumber;

    }

}


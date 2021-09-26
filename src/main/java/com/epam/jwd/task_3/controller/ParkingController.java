package com.epam.jwd.task_3.controller;


import com.epam.jwd.task_3.services.impl.ParkingServiceImpl;

import com.epam.jwd.task_3.view.ParkingView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;




public class ParkingController {

    private static final Logger logger = LogManager.getLogger(ParkingController.class);

    public static void main(String[] args) {

        Thread thread = new Thread(new ParkingServiceImpl());
        thread.setPriority(1);
        thread.start();
    }

    public int setCarNumber(){
        ParkingView carsView = new ParkingView();
        Scanner carsScanner = new Scanner(System.in);

        carsView.getCountOfCars();
        String countOfCars = carsScanner.nextLine();

        return getCarNumberAfterInput(countOfCars);
    }

    public int getCarNumberAfterInput(String countOfCars) {

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
                throw  new IllegalStateException("Unexpected value: " + countOfCars);

        }

        return carsNumber;

    }

    public int setParkingPlacesNumber(){
        ParkingView parkingView = new ParkingView();
        Scanner parkingScanner = new Scanner(System.in);

        parkingView.getCountOfParkingPlaces();

        String countOfParkingPlaces = parkingScanner.nextLine();

        return getParkingPlacesNumberAfterInput(countOfParkingPlaces);
    }

   public int getParkingPlacesNumberAfterInput(String countOfParkingPlaces){

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


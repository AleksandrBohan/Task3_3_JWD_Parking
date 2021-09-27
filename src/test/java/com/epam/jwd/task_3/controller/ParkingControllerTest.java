package com.epam.jwd.task_3.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ParkingControllerTest {

    ParkingController parkingController;

    @Test
    void checkCountOfCarsAfterInput() {
        int [] carsCount = {1,2,3,4,5};
        parkingController = new ParkingController();

        assertAll("numbersOfCars",
                () -> assertEquals(carsCount[0], parkingController
                        .getCarNumberAfterInput("1")),
                () -> assertEquals(carsCount[1], parkingController
                        .getCarNumberAfterInput("2")),
                () -> assertEquals(carsCount[2], parkingController
                        .getCarNumberAfterInput("3")),
                () -> assertEquals(carsCount[3], parkingController
                        .getCarNumberAfterInput("4")),
                () -> assertEquals(carsCount[4], parkingController
                        .getCarNumberAfterInput("5"))
        );
    }

    @Test
    void checkCountOfParkingPlacesNumberAfterInput() {
        int [] numbersOfCars = {5,10,15,20,25};
        parkingController = new ParkingController();

        assertAll("numbersOfCars",
                () -> assertEquals(numbersOfCars[0], parkingController
                        .getParkingPlacesNumberAfterInput("1")),
                () -> assertEquals(numbersOfCars[1], parkingController
                        .getParkingPlacesNumberAfterInput("2")),
                () -> assertEquals(numbersOfCars[2], parkingController
                        .getParkingPlacesNumberAfterInput("3")),
                () -> assertEquals(numbersOfCars[3], parkingController
                        .getParkingPlacesNumberAfterInput("4")),
                () -> assertEquals(numbersOfCars[4], parkingController
                        .getParkingPlacesNumberAfterInput("5"))
        );
    }
}
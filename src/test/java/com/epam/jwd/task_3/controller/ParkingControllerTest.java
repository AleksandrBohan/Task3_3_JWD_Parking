package com.epam.jwd.task_3.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingControllerTest {

    ParkingController parkingController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void checkCountOfCarsAfterInput() {
        int [] numbersOfCars = {1,2,3,4,5};
        parkingController = new ParkingController();

        assertAll("numbersOfCars",
                () -> assertEquals(numbersOfCars[0], parkingController.getCarNumberAfterInput("1")),
                () -> assertEquals(numbersOfCars[1], parkingController.getCarNumberAfterInput("2")),
                () -> assertEquals(numbersOfCars[2], parkingController.getCarNumberAfterInput("3")),
                () -> assertEquals(numbersOfCars[3], parkingController.getCarNumberAfterInput("4")),
                () -> assertEquals(numbersOfCars[4], parkingController.getCarNumberAfterInput("5"))
        );
    }

    @Test
    void getParkingPlacesNumberAfterInput() {
    }
}
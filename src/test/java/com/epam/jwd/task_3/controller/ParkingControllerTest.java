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
    void checkInputNumberForCarCount() {
        int [] numbersOfCars = {1,2,3,4,5};
        parkingController = new ParkingController();

        assertAll("numbersOfCars",
                () -> assertEquals(numbersOfCars[0], parkingController.setCarNumber()),
                () -> assertEquals(numbersOfCars[1], parkingController.setCarNumber()),
                () -> assertEquals(numbersOfCars[2], parkingController.setCarNumber()),
                () -> assertEquals(numbersOfCars[2], parkingController.setCarNumber()),
                () -> assertEquals(numbersOfCars[2], parkingController.setCarNumber())
        );
    }

    @Test
    void setParkingPlacesNumber() {
    }
}
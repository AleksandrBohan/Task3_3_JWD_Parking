package com.epam.jwd.task_3.services.api;


import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.impl.CarServiceImpl;
import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CarServiceTest {

    private static CarServiceImpl carService;

    private static SedanCarFactory sedanCarFactory;

    private static List<Car> carsList;

    @BeforeAll
    static void createObjects(){
        sedanCarFactory = new SedanCarFactory();
        carService = new CarServiceImpl();
        carsList = new ArrayList<>();
    }


    @Test
    void checkDifferentsBetweenCarInListAndCarInFactory() {
        carService.fillCarListForParking(sedanCarFactory, 1, carsList);

        assertAll("The same cars: ",
                () -> assertEquals(sedanCarFactory.getMercedesCar().getNameOfCar(),
                        carsList.get(0).getNameOfCar()),
                () -> assertEquals(sedanCarFactory.getToyotaCar().getNameOfCar(),
                        carsList.get(1).getNameOfCar()),
                () -> assertEquals(sedanCarFactory.getOpelCar().getNameOfCar(),
                        carsList.get(2).getNameOfCar()),
                () -> assertEquals(sedanCarFactory.getVolkswagenCar().getNameOfCar(),
                        carsList.get(3).getNameOfCar()),
                () -> assertEquals(sedanCarFactory.getRenaultCar().getNameOfCar(),
                        carsList.get(4).getNameOfCar())

        );
    }
}
package com.epam.jwd.task_3.repository.api;

import com.epam.jwd.task_3.repository.impl.CarRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;

import com.epam.jwd.task_3.services.logic.PersonalNumberGenerator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class CarRepositoryTest {

    int carItemNumber = 0;

    private static Car car;

    private static CarRepositoryImpl carRepository;

    private static List<Car> carCount = new ArrayList<Car>();

   @BeforeAll
    static void createObjects(){
        carCount = new ArrayList<>();
        car = new Car("Honda Civic", 6758L, "FE");
        carRepository = new CarRepositoryImpl();
    }

    @Test
    void checkCarAdditionToList() {
        carRepository.save(car, carCount);
        assertAll("The same cars: ",
                () -> assertEquals(car.getNameOfCar(), carCount.get(carItemNumber).getNameOfCar()),
                () -> assertEquals(car.getPersonalNumberOfCar(), carCount
                        .get(carItemNumber).getPersonalNumberOfCar()),
                () -> assertEquals(car.getSeriesOfNumber(), carCount
                        .get(carItemNumber).getSeriesOfNumber())

        );
    }
}
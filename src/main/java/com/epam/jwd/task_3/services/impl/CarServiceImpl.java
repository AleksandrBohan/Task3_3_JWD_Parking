package com.epam.jwd.task_3.services.impl;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarService;




public class CarServiceImpl implements CarService {


    @Override
    public void getCarOutput(Car car) {
        System.out.println(car.toString());
    }
}

package com.epam.jwd.task_3.services.impl;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.ParkingService;

import java.util.concurrent.Exchanger;


public class ParkingServiceImpl implements ParkingService {

    Exchanger<Car> carExchanger = new Exchanger<>();

    @Override
    public void swapNearbyCars(Car car) {

        try {
            carExchanger.exchange(car);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        new CarServiceImpl().getCarOutput(car);

    }
}

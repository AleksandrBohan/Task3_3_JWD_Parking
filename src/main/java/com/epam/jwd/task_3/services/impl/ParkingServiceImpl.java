package com.epam.jwd.task_3.services.impl;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.ParkingService;
import com.epam.jwd.task_3.services.exchanger.ConsumerForExchange;
import com.epam.jwd.task_3.services.exchanger.ProducerForExchange;

import java.util.concurrent.Exchanger;


public class ParkingServiceImpl implements ParkingService {

    Exchanger<Car> carExchanger = new Exchanger<>();

    @Override
    public void swapNearbyCars(Car car, Car otherCar) {
        new Thread(new ProducerForExchange(carExchanger, car)).start();
        new Thread(new ConsumerForExchange(carExchanger, otherCar)).start();
    }
}

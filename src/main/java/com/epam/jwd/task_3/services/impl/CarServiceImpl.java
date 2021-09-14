package com.epam.jwd.task_3.services.impl;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.Parking;
import com.epam.jwd.task_3.services.api.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

    private static final Integer POSITION_OF_CAR = 1;

    @Override
    public void createListOfCars(List<Car> list, Car car) {
        list.add(car);
    }

    @Override
    public void setTimeForCarOnParkingPlace(Parking[][] parking, int milis) {
        for (int i = 0; i < parking.length; i++){
            try {
                parking[i][POSITION_OF_CAR].wait(milis);
            } catch (InterruptedException e) {
               //TODO logger.error
            }
        }
    }

    @Override
    public void setWaitingForCarOutOfParking(List<Car> cars, Parking[][] parking, int milis) {
        for (int i = parking.length + 1; i < cars.size(); i++){
            try {
                cars.get(i).wait(milis);
            } catch (InterruptedException e) {
                //TODO logger.error
            }
        }
    }

}

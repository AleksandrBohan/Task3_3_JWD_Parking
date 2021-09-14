package com.epam.jwd.task_3.services.impl;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.ParkingPlace;
import com.epam.jwd.task_3.services.api.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    @Override
    public void createListOfCars(List<Car> list, Car car) {
        list.add(car);
    }

    @Override
    public void setTimeForCarOnParkingPlace(ParkingPlace[] parkingPlaces, int milis) {
        for (int i = 0; i < parkingPlaces.length; i++){
            try {
                parkingPlaces[i].wait(milis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void setWaitingForCarOutOfParking(List list, ParkingPlace[] parkingPlaces, int milis) {
        for (int i = parkingPlaces.length + 1; i < list.size(); i++){
            try {
                list.get(i).wait(milis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

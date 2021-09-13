package com.epam.jwd.task_3.repository.impl;

import com.epam.jwd.task_3.repository.api.ParkingRepository;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.ParkingPlace;

import java.util.List;

public class ParkingRepositoryImpl implements ParkingRepository {

    @Override
    public void fillEveryCarById(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
                cars.get(i).setPersonalNumberOfCar(i+1l);

            }

    }

    @Override
    public void fillEveryParkingPlaceById(List<ParkingPlace> parkingPlaces) {
        for (int i = 0; i < parkingPlaces.size(); i++) {
            parkingPlaces.get(i).setIndexOfPlace(i+1);

        }

    }

}

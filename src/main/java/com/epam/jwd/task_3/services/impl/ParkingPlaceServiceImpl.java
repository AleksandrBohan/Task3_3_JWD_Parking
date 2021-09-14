package com.epam.jwd.task_3.services.impl;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.Parking;
import com.epam.jwd.task_3.services.api.ParkingPlaceService;

public class ParkingPlaceServiceImpl implements ParkingPlaceService {


    @Override
    public Object[] getArrayOfParkingPlaces(int parkingPlacesCount, Object[] parking) {
        parking = new Parking[parkingPlacesCount];
        return parking;
    }

    @Override
    public void setCar(Car car, Object[] parking) {
        for (int i = 0; i < parking.length; i++) {
            parking[i] = car;

        }
    }
}

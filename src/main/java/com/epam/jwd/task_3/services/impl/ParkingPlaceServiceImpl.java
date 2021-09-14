package com.epam.jwd.task_3.services.impl;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.Parking;
import com.epam.jwd.task_3.repository.model.ParkingPlace;
import com.epam.jwd.task_3.services.api.ParkingPlaceService;

public class ParkingPlaceServiceImpl implements ParkingPlaceService {


    @Override
    public void setCar(Car car, int parkingPlacesCount, Object[] parking) {
        parking = new Parking[parkingPlacesCount];

        for (int i = 0; i < parkingPlacesCount; i++) {
            parking[i] = car;

        }

    }

}

package com.epam.jwd.task_3.services.api;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.Parking;
import com.epam.jwd.task_3.repository.model.ParkingPlace;

import java.util.Map;

public interface ParkingService {

    Parking setCountOfPlaces(ParkingPlace [] parkingPlaces);
    Parking swapNearbyCars(Map<ParkingPlace, Car> placeCar);

}

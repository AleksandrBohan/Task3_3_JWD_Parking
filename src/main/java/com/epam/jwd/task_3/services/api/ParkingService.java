package com.epam.jwd.task_3.services.api;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.Parking;

import java.util.Map;

public interface ParkingService {

    void setParkingSize(int size);
    Parking swapNearbyCars(Map<ParkingPlace, Car> placeCar, Parking[][] parking);

}

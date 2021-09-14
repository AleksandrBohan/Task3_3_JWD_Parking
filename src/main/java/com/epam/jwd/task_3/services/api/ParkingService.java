package com.epam.jwd.task_3.services.api;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.Parking;
import com.epam.jwd.task_3.repository.model.ParkingPlace;

import java.util.List;
import java.util.Map;

public interface ParkingService {

    void setParkingSize(int size);
    Parking swapNearbyCars(Map<ParkingPlace, Car> placeCar, Parking[][] parking);

}

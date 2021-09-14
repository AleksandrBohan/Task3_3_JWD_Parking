package com.epam.jwd.task_3.services.api;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.ParkingPlace;

import java.util.List;

public interface ParkingPlaceService {

   ParkingPlace setCar(Car car, int parkingPlacesCount);

}

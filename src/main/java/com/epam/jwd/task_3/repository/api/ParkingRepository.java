package com.epam.jwd.task_3.repository.api;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.ParkingPlace;

import java.util.List;

public interface ParkingRepository {

   void fillEveryCarById(List<Car> cars);
   void fillEveryParkingPlaceById(List<ParkingPlace> parkingPlaces);

}

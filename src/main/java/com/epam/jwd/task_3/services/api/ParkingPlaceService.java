package com.epam.jwd.task_3.services.api;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.Parking;
import com.epam.jwd.task_3.repository.model.ParkingPlace;

import java.util.List;

public interface ParkingPlaceService {

   void createListOfParkingPlaces(List<ParkingPlace> list, ParkingPlace parkingPlace);
   void addPlacesToParking(List<ParkingPlace> parkingPlaces, Parking[][] parking);

}

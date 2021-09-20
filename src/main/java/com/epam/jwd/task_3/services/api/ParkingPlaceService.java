package com.epam.jwd.task_3.services.api;

import com.epam.jwd.task_3.repository.model.Parking;

import java.util.List;

public interface ParkingPlaceService {

   void createListOfParkingPlaces(List<ParkingPlace> list, ParkingPlace parkingPlace);
   void addPlacesToParking(List<ParkingPlace> parkingPlaces, Parking[][] parking);

}

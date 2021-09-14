package com.epam.jwd.task_3.services.api;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.ParkingPlace;

import java.util.List;

public interface CarService {

   void createListOfCars(List<Car> list, Car car);
   void setTimeForCarOnParkingPlace(ParkingPlace[] parkingPlaces, int milis);
   void setWaitingForCarOutOfParking(List<Car> cars, ParkingPlace[] parkingPlaces, int milis);

}

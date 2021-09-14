package com.epam.jwd.task_3.services.api;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.Parking;


import java.util.List;

public interface CarService {

   void createListOfCars(List<Car> list, Car car);
   void addCarsToParking(List<Car> cars, Parking[][] parking);
   void setTimeForCarOnParkingPlace(Parking[][] parking, int milis);
   void setWaitingForCarOutOfParking(List<Car> cars, Parking[][] parking, int milis);

}

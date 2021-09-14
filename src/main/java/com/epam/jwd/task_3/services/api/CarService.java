package com.epam.jwd.task_3.services.api;

import com.epam.jwd.task_3.repository.model.Car;

import java.util.List;

public interface CarService {

   void createListOfCars(List<Car> list, Car car);
   void setTimeForCarOnParkingPlace(int milis);
   void setWaitingForCarOutOfParking(int milis);

}

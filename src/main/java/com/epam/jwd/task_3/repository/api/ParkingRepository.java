package com.epam.jwd.task_3.repository.api;

import com.epam.jwd.task_3.repository.model.Car;

import java.util.List;

public interface ParkingRepository {

  void addCar(Car car);
  void deleteCar();

}

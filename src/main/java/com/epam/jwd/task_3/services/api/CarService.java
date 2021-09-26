package com.epam.jwd.task_3.services.api;

import com.epam.jwd.task_3.repository.model.Car;

import java.util.List;




public interface CarService {

  List<Car> fillCarListForParking(CarFactory factory, int countOfCars, List<Car> carStorage);

}

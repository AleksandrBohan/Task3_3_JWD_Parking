package com.epam.jwd.task_3.services.impl;

import com.epam.jwd.task_3.repository.impl.CarRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.api.ParkingService;
import com.epam.jwd.task_3.services.exchanger.ConsumerForExchange;
import com.epam.jwd.task_3.services.exchanger.ProducerForExchange;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.concurrent.Exchanger;


public class ParkingServiceImpl implements ParkingService{

    private int countOfCars;

    private List <Car> carStorage = Collections.synchronizedList(new ArrayList<>());

    private Exchanger<Car> carExchanger = new Exchanger<>();

    @Override
    public void swapNearbyCars(Car car, Car otherCar) {
        new Thread(new ProducerForExchange(carExchanger, car)).start();
        new Thread(new ConsumerForExchange(carExchanger, otherCar)).start();
    }

    @Override
    public List<Car> fillCarListForParking(CarFactory factory, int countOfCars) {
        this.countOfCars = countOfCars;
      for (int i = 0; i < countOfCars; i++){

          new CarRepositoryImpl().save(factory.getMercedesCar(), carStorage);
          System.out.println(carStorage.get(0));

          new CarRepositoryImpl().save(factory.getToyotaCar(), carStorage);
          System.out.println(carStorage.get(1));

          new CarRepositoryImpl().save(factory.getOpelCar(), carStorage);
          System.out.println(carStorage.get(2));

          new CarRepositoryImpl().save(factory.getVolkswagenCar(), carStorage);
          System.out.println(carStorage.get(3));

          new CarRepositoryImpl().save(factory.getRenaultCar(), carStorage);
          System.out.println(carStorage.get(4));



      }

      return carStorage;

    }

}

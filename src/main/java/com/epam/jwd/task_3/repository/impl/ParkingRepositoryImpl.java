package com.epam.jwd.task_3.repository.impl;


import com.epam.jwd.task_3.repository.api.ParkingRepository;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.impl.ParkingServiceImpl;
import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ParkingRepositoryImpl implements ParkingRepository {

    private static final int SIZE_OF_PARKING_TIME = 3;
    private BlockingQueue<Car> parkingPlaces;
    CarFactory carFactory = new SedanCarFactory();
    List<Car> cars = Collections.synchronizedList(new ArrayList<>());
    Scanner scanner = new Scanner(System.in);

    @Override
    public void addCar() {
        this.parkingPlaces = parkingPlaces;
        parkingPlaces = new ArrayBlockingQueue<Car>(1, true);
        int factoryCapacity = new ParkingServiceImpl().fillCarListForParking(carFactory, 5, cars).size();
        try {
            for (int i = 0; i < factoryCapacity; i++){
                System.out.println("Car is trying to park: " +
                        parkingPlaces.offer(cars.get(i), SIZE_OF_PARKING_TIME, TimeUnit.MILLISECONDS));
                if (i == 3){

                }
           // boolean pC1 = parkingPlaces.offer(car, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS);
           // System.out.println("Car is trying to park: " + car + "  " + parkingCar);

              /*  if (!pC1) {
                    System.out.println("Parking was failed! Sleep sometime!");
                }
                else  {
                    System.out.println("success!! Car was parked!");
                }*/}

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public void deleteCar() {
        try {
            System.out.println("Car was deleted" + parkingPlaces.take());

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}

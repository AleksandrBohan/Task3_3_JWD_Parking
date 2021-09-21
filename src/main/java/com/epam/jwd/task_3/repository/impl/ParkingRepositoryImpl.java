package com.epam.jwd.task_3.repository.impl;

import com.epam.jwd.task_3.repository.api.ParkingRepository;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.Parking;
import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;




public class ParkingRepositoryImpl implements ParkingRepository, Runnable {

    private static final int SIZE_OF_PARKING_TIME = 3;
    private ArrayBlockingQueue<Car> parkingPlaces = new ArrayBlockingQueue<Car>(1, true);

    @Override
    public void addCar(Car car) {
        try {
            boolean parkingCar = parkingPlaces.offer(car, SIZE_OF_PARKING_TIME, TimeUnit.MICROSECONDS);
            System.out.println("Car is trying to park: " + car + "  " + parkingCar);

                if (!parkingCar) {
                    System.out.println("Parking was failed! Sleep sometime!");
                }
                else  {
                    System.out.println("success!! Car was parked!");
                }

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

    public void run(){
        ArrayBlockingQueue<Car> parkingPlacesIS = new ArrayBlockingQueue<Car>(1, true);
        try {
            boolean parkingCa1r = parkingPlacesIS.offer(new SedanCarFactory().getMercedesCar(), SIZE_OF_PARKING_TIME, TimeUnit.MICROSECONDS);
            System.out.println("Car is trying to park: " + new SedanCarFactory().getMercedesCar() + "  " );

            if (!parkingCa1r) {
                System.out.println("Parking was failed! Sleep sometime!");
            }
            else  {
                System.out.println("success!! Car was parked!");
            }

        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }
}

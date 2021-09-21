package com.epam.jwd.task_3.controller.threads;

import com.epam.jwd.task_3.controller.ParkingController;
import com.epam.jwd.task_3.repository.impl.CarRepositoryImpl;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;

public class ParkingServiceImplThread implements Runnable {

    @Override
    public void run() {
        CarFactory factory = new SedanCarFactory();
        int countOfCars = new ParkingController().getCountOfCars();
        countOfCars *= 5;
        for (int i = 0; i < countOfCars; i++){

            new CarRepositoryImpl().save(factory.getMercedesCar(),new ParkingController().getCars());
            System.out.println(new ParkingController().getCars().get(0));

            new CarRepositoryImpl().save(factory.getToyotaCar(), new ParkingController().getCars());
            System.out.println(new ParkingController().getCars().get(1));

            new CarRepositoryImpl().save(factory.getOpelCar(), new ParkingController().getCars());
            System.out.println(new ParkingController().getCars().get(2));

            new CarRepositoryImpl().save(factory.getVolkswagenCar(), new ParkingController().getCars());
            System.out.println(new ParkingController().getCars().get(3));

            new CarRepositoryImpl().save(factory.getRenaultCar(), new ParkingController().getCars());
            System.out.println(new ParkingController().getCars().get(4));

        }
    }
}

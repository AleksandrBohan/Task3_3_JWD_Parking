package com.epam.jwd.task_3.services.threads;

import com.epam.jwd.task_3.repository.impl.ParkingRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.impl.ParkingServiceImpl;
import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class ParkingRepositiryImplProducer implements Runnable {
    private CarFactory factory = new SedanCarFactory();

    ArrayBlockingQueue<Car> parkingPlacesIS = new ArrayBlockingQueue<Car>(1);

    private List<Car> carStorage = Collections.synchronizedList(new ArrayList<Car>());


    @Override
    public void run() {
        new ParkingServiceImpl().fillCarListForParking(factory, 5, carStorage);
        for (int i = 0; i < carStorage.size(); i++){
            new ParkingRepositoryImpl().addCar(carStorage.get(i), parkingPlacesIS);
        }
    }
}

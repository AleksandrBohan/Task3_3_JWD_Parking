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

    @Override
    public void run() {
        new ParkingServiceImpl().fillParkingFromCarList();

    }
}

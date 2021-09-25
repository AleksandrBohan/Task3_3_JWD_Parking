package com.epam.jwd.task_3.services.impl;


import com.epam.jwd.task_3.repository.impl.ParkingRepositoryImpl;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.api.ParkingService;
import com.epam.jwd.task_3.services.exchanger.ConsumerForExchange;
import com.epam.jwd.task_3.services.exchanger.ProducerForExchange;
import com.epam.jwd.task_3.services.impl.car_factory.SedanCarFactory;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Exchanger;



public class ParkingServiceImpl implements ParkingService, Runnable{

    private int countOfCars;
    private BlockingQueue<Car> parkingPlaces;
    CarFactory carFactory = new SedanCarFactory();
    List<Car> cars = Collections.synchronizedList(new ArrayList<>());

    private Exchanger<Car> carExchanger = new Exchanger<>();


    @Override
    public void swapNearbyCars(Car car, Car otherCar) {

        Thread producerThread = new Thread(new ProducerForExchange(carExchanger, car));
        Thread consumerThread = new Thread(new ConsumerForExchange(carExchanger, otherCar));
        producerThread.setPriority(10);
        consumerThread.setPriority(5);
        producerThread.start();
        consumerThread.start();
    }

    public void fillParkingFromCarList() {
        boolean deleteStatement = true;
        int numberForExchange = 1;
        parkingPlaces = new ArrayBlockingQueue<>(20, true);

        int factoryCapacity = new CarServiceImpl().fillCarListForParking(carFactory, 5, cars).size();
        Car car = null;
        int countOfDelete = 0;
        for (int j = 0; j < factoryCapacity; j++) {
            for (int i = 0; i < factoryCapacity; i++) {
                if (!(cars.get(i).equals(cars.get(j)))) {

                        if ((new ParkingRepositoryImpl().addPairOfCars(cars.get(i), cars.get(j), parkingPlaces,
                                numberForExchange) == true)) {
                                if (countOfDelete == 1){
                                    swapNearbyCars(cars.get(j), car);
                                } else {
                                    swapNearbyCars(cars.get(i), cars.get(j));
                                }
                            if (i % 6 == 0) {
                                new ParkingRepositoryImpl().deleteCar(parkingPlaces);
                                countOfDelete = 1;
                                car = cars.get(j);

                            }
                        } else {

                            System.out.println("Exchange isn't availiable!!");
                        }

                        countOfDelete = 0;


                        /*if (i % 6 == 0) {
                           new ParkingRepositoryImpl().deleteCar(parkingPlaces);
                           countOfDelete = 1;
                           car = cars.get(j);

                        }*/


                    }
                }
            }
        }



    public int getCountOfCars() {
        return countOfCars;
    }

    public void setCountOfCars(int countOfCars) {
        this.countOfCars = countOfCars;
    }


    public Exchanger<Car> getCarExchanger() {
        return carExchanger;
    }

    public void setCarExchanger(Exchanger<Car> carExchanger) {
        this.carExchanger = carExchanger;
    }

    @Override
    public void run() {
        fillParkingFromCarList();
    }
}

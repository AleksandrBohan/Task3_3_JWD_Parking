package com.epam.jwd.task_3.services.impl.car_factory;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.logic.PersonalNumberGenerator;

public class SedanCarFactory implements CarFactory {

    private static final String SERIES_NAME = "EA";

    @Override
    public Car getOpelCar() {
        Car car = new Car("Opel Insignia", new PersonalNumberGenerator().generateId(), SERIES_NAME);
        return car;
    }

    @Override
    public Car getToyotaCar() {
        Car car = new Car("Toyota Camry", new PersonalNumberGenerator().generateId(), SERIES_NAME);
        return car;
    }

    @Override
    public Car getVolkswagenCar() {
        Car car = new Car("Volkswagen Polo", new PersonalNumberGenerator().generateId(), SERIES_NAME);
        return car;
    }

    @Override
    public Car getRenaultCar() {
        Car car =  new Car("Renault Logan", new PersonalNumberGenerator().generateId(), SERIES_NAME);
        return car;
    }

    @Override
    public Car getMercedesCar() {
        Car car = new Car("Mercedes-Benz A-Class AMG", new PersonalNumberGenerator().generateId(), SERIES_NAME);
        return car;
    }
}

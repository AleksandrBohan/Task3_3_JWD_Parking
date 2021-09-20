package com.epam.jwd.task_3.services.impl.car_factory;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.services.api.CarFactory;
import com.epam.jwd.task_3.services.logic.PersonalNumberGenerator;

public class SedanCarFactory implements CarFactory {

    private static final String SERIES_NAME = "EA";

    @Override
    public Car getOpelCar() {
        return new Car("Opel Insignia", PersonalNumberGenerator.generateId(), SERIES_NAME);
    }

    @Override
    public Car getToyotaCar() {
        return new Car("Toyota Camry", PersonalNumberGenerator.generateId(), SERIES_NAME);
    }

    @Override
    public Car getVolkswagenCar() {
        return new Car("Volkswagen Polo", PersonalNumberGenerator.generateId(), SERIES_NAME);
    }

    @Override
    public Car getRenaultCar() {
        return new Car("Renault Logan", PersonalNumberGenerator.generateId(), SERIES_NAME);
    }

    @Override
    public Car getMercedesCar() {
        return new Car("Mercedes-Benz A-Class AMG", PersonalNumberGenerator.generateId(), SERIES_NAME);
    }
}

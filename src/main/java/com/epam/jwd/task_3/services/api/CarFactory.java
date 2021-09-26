package com.epam.jwd.task_3.services.api;

import com.epam.jwd.task_3.repository.model.Car;




public interface CarFactory {

    Car getOpelCar();

    Car getToyotaCar();

    Car getVolkswagenCar();

    Car getRenaultCar();

    Car getMercedesCar();

}

package com.epam.jwd.task_3.repository.api;

import com.epam.jwd.task_3.repository.model.Car;

import java.util.List;

public interface CarRepository {

    void save(Car car, List<Car> carStorage);

}

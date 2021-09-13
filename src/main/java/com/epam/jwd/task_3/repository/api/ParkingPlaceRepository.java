package com.epam.jwd.task_3.repository.api;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.ParkingPlace;

import java.util.List;

public interface ParkingPlaceRepository {

    void save(ParkingPlace parkingPlace);
    ParkingPlace findById(Long id);
    boolean delete(ParkingPlace parkingPlace);

}

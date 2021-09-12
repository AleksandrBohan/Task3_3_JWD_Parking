package com.epam.jwd.task_3.repository.api;

import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.ParkingPlace;

public interface ParkingPlaceRepository {

    void save(ParkingPlace parkingPlace);
    void findById(ParkingPlace id);
    boolean delete(ParkingPlace parkingPlace);

}

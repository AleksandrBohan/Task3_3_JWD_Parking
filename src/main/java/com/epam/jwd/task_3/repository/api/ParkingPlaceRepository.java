package com.epam.jwd.task_3.repository.api;

public interface ParkingPlaceRepository {

    void save(ParkingPlace parkingPlace);
    ParkingPlace findById(Long id);
    boolean delete(ParkingPlace parkingPlace);

}

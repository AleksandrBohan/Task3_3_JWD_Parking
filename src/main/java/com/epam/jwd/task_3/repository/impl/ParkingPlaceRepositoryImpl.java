package com.epam.jwd.task_3.repository.impl;

import com.epam.jwd.task_3.repository.api.ParkingPlaceRepository;

import java.util.ArrayList;
import java.util.List;



public class ParkingPlaceRepositoryImpl implements ParkingPlaceRepository {

    private CarRepositoryImpl instance;

    private List<ParkingPlace> parkingPlaceStorage = new ArrayList<>();

    @Override
    public void save(ParkingPlace parkingPlace) {
        try{
            parkingPlaceStorage.add(parkingPlace);
        }
        catch (Exception exception){
            //TODO write exception for it!!!
        }
    }

    @Override
    public ParkingPlace findById(Long id) {

        return parkingPlaceStorage.stream()
                .filter(parkingPlace -> id.equals(parkingPlace.getIndexOfPlace()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean delete(ParkingPlace parkingPlace) {
        return parkingPlaceStorage.remove(parkingPlace);
    }

}

package com.epam.jwd.task_3.repository.model;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class Parking {

    private BlockingQueue<Car> parkingPlaces = new ArrayBlockingQueue<Car>(1);

    public Parking(BlockingQueue<Car> parkingPlaces){
        setParkingPlaces(parkingPlaces);
    }


    public BlockingQueue<Car> getParkingPlaces() {
        return parkingPlaces;
    }

    public void setParkingPlaces(BlockingQueue<Car> parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return Objects.equals(parkingPlaces, parking.parkingPlaces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingPlaces);
    }

    @Override
    public String toString() {
        return "Parking{" +
                "parkingPlaces=" + parkingPlaces +
                '}';
    }
}
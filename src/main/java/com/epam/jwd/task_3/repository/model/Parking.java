package com.epam.jwd.task_3.repository.model;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;




public class Parking {

    private static final int SIZE_OF_PARKING = 5;

    private ArrayBlockingQueue<Car> parkingPlaces = new ArrayBlockingQueue<Car>(SIZE_OF_PARKING);

    public static int getSizeOfParking() {
        return SIZE_OF_PARKING;
    }

    public ArrayBlockingQueue<Car> getParkingPlaces() {
        return parkingPlaces;
    }

    public void setParkingPlaces(ArrayBlockingQueue<Car> parkingPlaces) {
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
package com.epam.jwd.task_3.repository.model;

import java.util.Arrays;

public class Parking {

    private Car [] car;

    private ParkingPlace [] countOfPlaces;

    public Parking(Car [] car, ParkingPlace [] countOfPlaces){

    }

    public Car[] getCar() {
        return car;
    }

    public void setCar(Car[] car) {
        this.car = car;
    }

    public ParkingPlace[] getCountOfPlaces() {
        return countOfPlaces;
    }

    public void setCountOfPlaces(ParkingPlace[] countOfPlaces) {
        this.countOfPlaces = countOfPlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return Arrays.equals(car, parking.car) &&
                Arrays.equals(countOfPlaces, parking.countOfPlaces);
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(car);
        result = 31 * result + Arrays.hashCode(countOfPlaces);
        return result;
    }

    @Override
    public String toString() {
        return "Parking{" +
                "car=" + Arrays.toString(car) +
                ", countOfPlaces=" + Arrays.toString(countOfPlaces) +
                '}';
    }
}

package com.epam.jwd.task_3.repository.model;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Parking {

    private List<Car> cars = new ArrayList<>();

    private List<ParkingPlace> parkingPlaces = new ArrayList<>();

    public Parking(List<Car> cars, List<ParkingPlace> parkingPlaces){

    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<ParkingPlace> getParkingPlaces() {
        return parkingPlaces;
    }

    public void setParkingPlaces(List<ParkingPlace> parkingPlaces) {
        this.parkingPlaces = parkingPlaces;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parking parking = (Parking) o;
        return Objects.equals(cars, parking.cars) &&
                Objects.equals(parkingPlaces, parking.parkingPlaces);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cars, parkingPlaces);
    }

    @Override
    public String toString() {
        return "Parking{" +
                "cars=" + cars +
                ", parkingPlaces=" + parkingPlaces +
                '}';
    }
}
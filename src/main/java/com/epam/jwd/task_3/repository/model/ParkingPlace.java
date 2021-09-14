package com.epam.jwd.task_3.repository.model;

import java.util.Objects;

public class ParkingPlace extends Parking {

    private int indexOfPlace;

    public ParkingPlace(int indexOfPlace){
       setIndexOfPlace(indexOfPlace);
    }


    public int getIndexOfPlace() {
        return indexOfPlace;
    }

    public void setIndexOfPlace(int indexOfPlace) {
        this.indexOfPlace = indexOfPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingPlace that = (ParkingPlace) o;
        return indexOfPlace == that.indexOfPlace;
    }

    @Override
    public int hashCode() {
        return Objects.hash(indexOfPlace);
    }

    @Override
    public String toString() {
        return "ParkingPlace{" +
                "indexOfPlace=" + indexOfPlace +
                '}';
    }
}

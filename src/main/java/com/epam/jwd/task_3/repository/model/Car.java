package com.epam.jwd.task_3.repository.model;

import java.util.Objects;


public class Car {

    private volatile String nameOfCar;

    private volatile Long personalNumberOfCar;

    private volatile String seriesOfNumber;

    public Car(String nameOfCar, Long personalNumberOfCar, String seriesOfNumber){
        setNameOfCar(nameOfCar);
        setPersonalNumberOfCar(personalNumberOfCar);
        setSeriesOfNumber(seriesOfNumber);

    }

    public String getNameOfCar() {
        return nameOfCar;
    }

    public void setNameOfCar(String nameOfCar) {
        this.nameOfCar = nameOfCar;
    }

    public Long getPersonalNumberOfCar() {
        return personalNumberOfCar;
    }

    public void setPersonalNumberOfCar(Long personalNumberOfCar) {
        this.personalNumberOfCar = personalNumberOfCar;
    }


    public String getSeriesOfNumber() {
        return seriesOfNumber;
    }

    public void setSeriesOfNumber(String seriesOfNumber) {
        this.seriesOfNumber = seriesOfNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(nameOfCar, car.nameOfCar) &&
                Objects.equals(personalNumberOfCar, car.personalNumberOfCar) &&
                Objects.equals(seriesOfNumber, car.seriesOfNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfCar, personalNumberOfCar, seriesOfNumber);
    }

    @Override
    public String toString() {
        return "Car{" +
                "nameOfCar='" + nameOfCar + '\'' +
                ", personalNumberOfCar=" + personalNumberOfCar +
                ", seriesOfNumber='" + seriesOfNumber + '\'' +
                '}';
    }

}

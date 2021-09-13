package com.epam.jwd.task_3.repository.model;

import java.util.Objects;

public class Car {

    private String nameOfCar;

    private Long personalNumberOfCar;

    public Car(String nameOfCar, Long personalNumberOfCar){
        setNameOfCar(nameOfCar);
        setPersonalNumberOfCar(personalNumberOfCar);

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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return personalNumberOfCar == car.personalNumberOfCar &&
                Objects.equals(nameOfCar, car.nameOfCar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameOfCar, personalNumberOfCar);
    }

    @Override
    public String toString() {
        return "Car{" +
                "nameOfCar='" + nameOfCar + '\'' +
                ", personalNumberOfCar=" + personalNumberOfCar +
                '}';
    }
}

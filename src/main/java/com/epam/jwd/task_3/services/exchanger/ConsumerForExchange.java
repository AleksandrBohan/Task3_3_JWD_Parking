package com.epam.jwd.task_3.services.exchanger;

import com.epam.jwd.task_3.repository.model.Car;

import java.util.concurrent.Exchanger;

public class ConsumerForExchange implements Runnable {

    private Exchanger<Car> exchanger;

    private Car car;

    public ConsumerForExchange(Exchanger<Car> exchanger, Car car){
        setExchanger(exchanger);
        setCar(car);

    }

    @Override
    public void run() {
        try {
            car = exchanger.exchange(car);
            System.out.println("Producer received car: " + car.toString());
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public Exchanger<Car> getExchanger() {
        return exchanger;
    }

    public void setExchanger(Exchanger<Car> exchanger) {
        this.exchanger = exchanger;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}

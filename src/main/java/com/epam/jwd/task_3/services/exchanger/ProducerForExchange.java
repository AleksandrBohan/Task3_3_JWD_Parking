package com.epam.jwd.task_3.services.exchanger;

import com.epam.jwd.task_3.repository.model.Car;

import java.util.concurrent.Exchanger;

public class ProducerForExchange implements Runnable {

    private Exchanger<Car> exchanger;

    private Car car;

    public ProducerForExchange(Exchanger<Car> exchanger, Car car){
       setExchanger(exchanger);
       setCar(car);

    }

    @Override
    public void run() {
        try {
            car = exchanger.exchange(car);
            System.out.println("-------------------------------------------" + "\n");
            System.out.println("Producer received car: " + car.toString());
            System.out.println("\n" + "-------------------------------------------");
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

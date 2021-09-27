package com.epam.jwd.task_3.services.exchanger;


import com.epam.jwd.task_3.repository.model.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Exchanger;




public class ConsumerForExchange implements Runnable {

    private Exchanger<Car> exchanger;

    private Car car;

    private static final Logger logger = LogManager.getLogger(ConsumerForExchange.class);

    public ConsumerForExchange(Exchanger<Car> exchanger, Car car){
        setExchanger(exchanger);
        setCar(car);

    }

    @Override
    public void run() {
        try {
            car = exchanger.exchange(car);
            logger.debug("-------------------------------------------" + "\n" +
                    "Consumer received car: " + car.toString() +
                    "\n" + "-------------------------------------------");

        } catch (InterruptedException exception) {
           logger.error("InterruptedException exception in ConsumerForExchange thread!" + exception);

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

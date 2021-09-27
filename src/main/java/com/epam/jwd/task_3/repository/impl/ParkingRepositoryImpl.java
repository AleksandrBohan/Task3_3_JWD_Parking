package com.epam.jwd.task_3.repository.impl;


import com.epam.jwd.task_3.repository.api.ParkingRepository;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.Parking;
import com.epam.jwd.task_3.services.impl.ParkingServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;




public class ParkingRepositoryImpl implements ParkingRepository {

    private boolean exchangeChecking;

    private static final int SIZE_OF_PARKING_TIME = 3;

    private static final Logger logger = LogManager.getLogger(ParkingRepositoryImpl.class);

    public static int getSizeOfParkingTime() {
        return SIZE_OF_PARKING_TIME;
    }

    public static Logger getLogger() {
        return logger;
    }


    @Override
    public boolean addPairOfCars(Car firstCar, Car secondCar, BlockingQueue<Car> parkingPlaces) {
        boolean carOnParkingFirst = false;
        Parking parking = new Parking(parkingPlaces);
        ParkingServiceImpl parkingService = new ParkingServiceImpl();

        try {
            logger.debug("-----------------------------------------" +
                    "\n" + "Car1 is trying to park: " + firstCar.toString());
            logger.debug("Car2 is trying to park: " + secondCar.toString() + "\n" +
                    "-----------------------------------------");

            if (parking.getParkingPlaces()
                    .offer(firstCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS) == true){
                carOnParkingFirst = true;
                logger.debug(firstCar.toString() + "\n" + " was parked!!");

                if (parking.getParkingPlaces()
                        .offer(secondCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS) == true) {
                   setExchangeChecking(false);
                    logger.debug(secondCar.toString() + "\n" + " was parked!!");

                } else if (parking.getParkingPlaces()
                        .offer(secondCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS) == false) {
                   setExchangeChecking(true);

                    logger.debug(secondCar.toString() + "\n" + " couldn't park!!");

                }

                return carOnParkingFirst;

            } else if (parking.getParkingPlaces()
                    .offer(firstCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS) == false){
               carOnParkingFirst = false;
               logger.debug(firstCar.toString() + "\n" + " couldn't park!!");
               logger.debug(secondCar.toString() + "\n" + " couldn't park!!");
                return carOnParkingFirst;

            }

        } catch (InterruptedException exception) {
             logger.error("InterruptedException in addPairOfCars() method! " + exception);

    }

        return carOnParkingFirst;

    }

    @Override
    public void deleteCar(BlockingQueue<Car> parkingPlaces) {
        Parking parking = new Parking(parkingPlaces);
        try {
            logger.debug("Car was deleted" + parking.getParkingPlaces().take());

        } catch (InterruptedException exception) {
            logger.error("InterruptedException in deleteCar() method!" + exception);

        }

    }

    public boolean isExchangeChecking() {
        return exchangeChecking;
    }

    public void setExchangeChecking(boolean exchangeChecking) {
        this.exchangeChecking = exchangeChecking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingRepositoryImpl that = (ParkingRepositoryImpl) o;
        return exchangeChecking == that.exchangeChecking;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exchangeChecking);
    }

    @Override
    public String toString() {
        return "ParkingRepositoryImpl{" +
                "exchangeChecking=" + exchangeChecking +
                '}';
    }
}

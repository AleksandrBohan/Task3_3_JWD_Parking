package com.epam.jwd.task_3.repository.impl;


import com.epam.jwd.task_3.repository.api.ParkingRepository;
import com.epam.jwd.task_3.repository.model.Car;
import com.epam.jwd.task_3.repository.model.Parking;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;




public class ParkingRepositoryImpl implements ParkingRepository {

    private static final int SIZE_OF_PARKING_TIME = 3;

    private static final Logger logger = LogManager.getLogger(ParkingRepositoryImpl.class);

    @Override
    public boolean addPairOfCars(Car firstCar, Car secondCar, BlockingQueue<Car> parkingPlaces) {
        boolean carOnParkingFirst = false;
        Parking parking = new Parking(parkingPlaces);
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
                    logger.debug(secondCar.toString() + "\n" + " was parked!!");

                } else if (parking.getParkingPlaces()
                        .offer(secondCar, SIZE_OF_PARKING_TIME, TimeUnit.SECONDS) == false) {
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
             logger.error("InterruptedException in addPairOfCars() method!");

    }

        return carOnParkingFirst;

    }

    @Override
    public void deleteCar(BlockingQueue<Car> parkingPlaces) {
        Parking parking = new Parking(parkingPlaces);
        try {
            logger.debug("Car was deleted" + parking.getParkingPlaces().take());

        } catch (InterruptedException exception) {
            logger.error("InterruptedException in deleteCar() method!");

        }

    }

}

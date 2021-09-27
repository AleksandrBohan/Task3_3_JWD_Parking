package com.epam.jwd.task_3.view;

public class ParkingView {

    private static final String CAR_COUNT = "\n" + "Input count of cars: " +
            "\n" + "1 - 8 cars will drive to the parking!" +
            "\n" + "2 - 18 cars will drive to the parking!" +
            "\n" + "3 - 28 cars will drive to the parking!" +
            "\n" + "4 - 38 cars will drive to the parking!" +
            "\n" + "5 - 48 cars will drive to the parking!" +
            "\n";

    private static final String PARKING_PLACES_COUNT = "\n" + "Input count of parking places: " +
            "\n" + "1 - add 5 places" +
            "\n" + "2 - add 10 places" +
            "\n" + "3 - add 15 places" +
            "\n" + "4 - add 20 places" +
            "\n" + "5 - add 25 places" +
            "\n";

    public void getCountOfCars(){
        System.out.println(CAR_COUNT);
    }

    public void getCountOfParkingPlaces(){
        System.out.println(PARKING_PLACES_COUNT);
    }
}


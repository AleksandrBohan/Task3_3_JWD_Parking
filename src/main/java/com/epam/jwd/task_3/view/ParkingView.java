package com.epam.jwd.task_3.view;

public class ParkingView {

    private static final String CAR_COUNT = "\n" + "Input count of cars: " +
            "\n" + "1 - add 5 cars" +
            "\n" + "2 - add 10 cars" +
            "\n" + "3 - add 15 cars" +
            "\n" + "4 - add 20 cars" +
            "\n" + "5 - add 25 cars" +
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


package com.epam.jwd.task_3.services.logic;

public class PersonalNumberGenerator {

    private static Long id = 999L;

    public static Long generateId() {
        return id++;
    }

}

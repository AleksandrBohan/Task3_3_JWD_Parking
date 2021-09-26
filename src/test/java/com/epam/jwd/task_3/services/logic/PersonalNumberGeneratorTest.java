package com.epam.jwd.task_3.services.logic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PersonalNumberGeneratorTest {

    private static PersonalNumberGenerator personalNumberGenerator;

    @BeforeAll
    static void createObject(){
        personalNumberGenerator = new PersonalNumberGenerator();
    }

    @Test
    void checkTheIncreaseOfTheNumberByOne() {
        AtomicReference<Long> expectedNumberForIncrease = new AtomicReference<>(1000L);

        assertAll("These numbers are equal: ",
                () -> assertEquals(expectedNumberForIncrease.getAndSet(expectedNumberForIncrease.get() + 1),
                        personalNumberGenerator.generateId()),
                () -> assertEquals(expectedNumberForIncrease.getAndSet(expectedNumberForIncrease.get() + 1),
                        personalNumberGenerator.generateId()),
                () -> assertEquals(expectedNumberForIncrease.getAndSet(expectedNumberForIncrease.get() + 1),
                        personalNumberGenerator.generateId())

        );
    }
}
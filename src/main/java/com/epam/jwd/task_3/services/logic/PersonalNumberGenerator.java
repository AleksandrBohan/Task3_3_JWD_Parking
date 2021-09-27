package com.epam.jwd.task_3.services.logic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;




public class PersonalNumberGenerator {

    private static Long personalNumber = 999L;

    private Lock lock = new ReentrantLock();

    public static Long getPersonalNumber() {
        return personalNumber;
    }

    public static void setPersonalNumber(Long personalNumber) {
        PersonalNumberGenerator.personalNumber = personalNumber;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Long generateId() {
        lock.lock();
        personalNumber++;
        lock.unlock();
        return personalNumber;
    }

}

package com.epam.jwd.task_3.services.logic;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;




public class PersonalNumberGenerator {

    private static Long personalNumber = 999L;

    private Lock lock = new ReentrantLock();

    public Long generateId() {
        lock.lock();
        personalNumber++;
        lock.unlock();
        return personalNumber;
    }

}

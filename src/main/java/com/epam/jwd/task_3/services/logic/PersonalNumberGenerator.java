package com.epam.jwd.task_3.services.logic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class PersonalNumberGenerator {

    private static Long personalNumber = 999L;

    private ReentrantLock lock = new ReentrantLock();

    public Long generateId() {
        lock.lock();
        personalNumber++;
        lock.unlock();
        return personalNumber;
    }

}

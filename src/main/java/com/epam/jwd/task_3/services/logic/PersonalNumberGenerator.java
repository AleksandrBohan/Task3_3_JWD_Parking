package com.epam.jwd.task_3.services.logic;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;

public class PersonalNumberGenerator {

    private static AtomicLong personalNumber = new AtomicLong(999L);

    private ReentrantLock lock = new ReentrantLock();

    public AtomicLong generateId() {
        lock.lock();
        personalNumber.getAndIncrement();
        lock.unlock();
        return personalNumber;
    }

}

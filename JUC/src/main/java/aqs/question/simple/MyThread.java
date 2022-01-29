package aqs.question.simple;

import java.util.concurrent.locks.Lock;

public class MyThread extends Thread {
    private Lock lock;
    private String name;

    public MyThread(String name, Lock lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println(Thread.currentThread() + " running...");
        lock.unlock();
    }
}

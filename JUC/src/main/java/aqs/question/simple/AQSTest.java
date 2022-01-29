package aqs.question.simple;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AQSTest {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        MyThread thread1 = new MyThread("thread1", lock);
        MyThread thread2 = new MyThread("thread2", lock);
        thread1.start();
        thread2.start();
    }
}

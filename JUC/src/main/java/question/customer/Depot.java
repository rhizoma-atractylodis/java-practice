package question.customer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Depot {
    private int capacity;
    private int size;
    private Lock lock;
    private Condition fullCondition;
    private Condition emptyCondition;

    public Depot(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        emptyCondition = lock.newCondition();
    }

    public void produce(int no) {
        lock.lock();
        int left = no;
        try {
            while (left > 0) {
                while (size >= capacity) {
                    System.out.println(Thread.currentThread() + " before await...");
                    fullCondition.await();
                    System.out.println(Thread.currentThread() + " after await...");
                }
                int increase = (left + size) > capacity ? (capacity - size) : left;
                left -= increase;
                size += increase;
                System.out.println("produce = " + increase + ", current size = " + size);
                emptyCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume(int no) {
        lock.lock();
        int left = no;
        try {
            while (left > 0) {
                while (size <= 0) {
                    System.out.println(Thread.currentThread() + " before await...");
                    emptyCondition.await();
                    System.out.println(Thread.currentThread() + " after await...");
                }
                int decrease = (size - left) < 0 ? size : left;
                left -= decrease;
                size -= decrease;
                System.out.println("consume = " + decrease + ", current size = " + size);
                fullCondition.signal();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

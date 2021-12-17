package thread.status;

import java.util.Currency;
import java.util.Objects;

public class StatusDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                if (i == 500) {
                    Thread t = Thread.currentThread();
                    synchronized (t) {
                        System.out.println("wait for 1s...");
                        try {
                            t.wait(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("continue to running...");
                    }
                }
//                if (i == 800) {
//                    System.out.println("wait for random time...");
//                    try {
//                        Thread.currentThread().wait();
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    Thread.currentThread().notify();
//                }
                System.out.println(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}

package synchronized_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchronizedDemo {
    public static void main(String[] args) {
        SynchronizedTest obj = new SynchronizedTest();
        Thread t1 = new Thread(() -> {
            try {
                obj.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                obj.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
    }
}

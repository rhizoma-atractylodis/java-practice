package synchronized_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchronizedTest {
    private final Object block1 = new Object();
    private final Object block2 = new Object();

    public synchronized void method() throws InterruptedException {
        log.info("thread " + Thread.currentThread().getName() + " start...");
        Thread.sleep(3000);
        log.info("thread " + Thread.currentThread().getName() + " end...");
    }

    public void run() throws InterruptedException {
        synchronized (block1) {
            log.info("block1 " + Thread.currentThread().getName() + " start...");
            Thread.sleep(3000);
            log.info("block1 " + Thread.currentThread().getName() + " end...");
        }
        synchronized (block2) {
            log.info("block2 " + Thread.currentThread().getName() + " start...");
            Thread.sleep(3000);
            log.info("block2 " + Thread.currentThread().getName() + " end...");
        }
    }
}

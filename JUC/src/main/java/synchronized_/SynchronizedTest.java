package synchronized_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SynchronizedTest {
    public synchronized void method() throws InterruptedException {
        log.info("thread "+Thread.currentThread().getName()+" start...");
        Thread.sleep(3000);
        log.info("thread "+Thread.currentThread().getName()+" end...");
    }
}

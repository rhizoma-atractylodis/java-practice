package volatile_;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileDemo {
    public static void main(String[] args) {
        final int[] value = {0};
        VolatileCheesyCounter counter = new VolatileCheesyCounter();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
//                value[0]++;
                counter.increase();
                log.info(String.valueOf(counter.getValue()));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
//                value[0]++;
                counter.increase();
                log.info(String.valueOf(counter.getValue()));
            }
        });
        thread1.start();
        thread2.start();
    }
}

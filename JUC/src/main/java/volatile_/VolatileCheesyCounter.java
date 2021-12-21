package volatile_;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

@ThreadSafe
public class VolatileCheesyCounter {
    @GuardedBy("this")
    private volatile int value = 0;

    public int getValue() {
        return value;
    }

    public synchronized int increase() {
        return value++;
    }
}

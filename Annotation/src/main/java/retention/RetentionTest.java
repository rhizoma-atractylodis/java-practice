package retention;

public class RetentionTest {
    @SourcePolicy
    public static void source() {
    }

    @ClassPolicy
    public static void clazz() {
    }

    @RuntimePolicy
    public static void runtime() {
    }

    public static void main(String[] args) {
        source();
        clazz();
        runtime();
    }
}

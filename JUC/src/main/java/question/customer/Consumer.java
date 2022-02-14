package question.customer;

public class Consumer {
    private Depot depot;

    public Consumer(Depot depot) {
        this.depot = depot;
    }

    public void consume(int no) {
        new Thread(() -> {
            depot.consume(no);
        }, no + " consume thread").start();
    }
}

package question.customer;

public class Producer {
    private Depot depot;

    public Producer(Depot depot) {
        this.depot = depot;
    }

    public void produce(int no) {
        new Thread(() -> {
            depot.produce(no);
        }, no + " produce thread").start();
    }
}

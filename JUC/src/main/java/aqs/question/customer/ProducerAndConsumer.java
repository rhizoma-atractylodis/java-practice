package aqs.question.customer;

public class ProducerAndConsumer {
    public static void main(String[] args) {
        Depot depot = new Depot(500);
        new Producer(depot).produce(300);
        new Consumer(depot).consume(500);
        new Producer(depot).produce(200);
        new Consumer(depot).consume(200);
        new Producer(depot).produce(200);
    }
}

package pl.coderstrust.multiThreading.blockingqueue;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo1ProducerSomeConsumersSleeping {

    private static final int DEFAULT_CAPACITY = 10;

    public static void main(String[] args) {
        BlockingQueue<Integer> warehouse = new LinkedBlockingQueue<>(DEFAULT_CAPACITY);
        int consumersNumber = 3;
        ExecutorService service = Executors.newFixedThreadPool(consumersNumber + 1);
        service.execute(new Producer(warehouse, Duration.ofSeconds(0)));
        for (int i = 0; i < consumersNumber; i++) {
            service.execute(new Consumer(warehouse, Duration.ofSeconds(1)));
        }
    }
}

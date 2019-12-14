package pl.coderstrust.multiThreading.blockingqueue;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class DemoSomeProducers1ConsumerSleeping {

    private static final int DEFAULT_CAPACITY = 10;

    public static void main(String[] args) {
        BlockingQueue<Integer> warehouse = new LinkedBlockingQueue<>(DEFAULT_CAPACITY);
        int producersNumber = 3;
        ExecutorService service = Executors.newFixedThreadPool(producersNumber + 1);
        for (int i = 0; i < producersNumber; i++) {
            service.execute(new Producer(warehouse, Duration.ofSeconds(0)));
        }
        service.execute(new Consumer(warehouse, Duration.ofSeconds(1)));
    }
}

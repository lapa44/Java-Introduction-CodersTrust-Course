package pl.coderstrust.multiThreading.BlockingQueue;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo1ProducerSleeping1Consumer {

    private static final int DEFAULT_CAPACITY = 10;

    public static void main(String[] args) {
        BlockingQueue<Integer> warehouse = new LinkedBlockingQueue<>(DEFAULT_CAPACITY);
        ExecutorService service = Executors.newFixedThreadPool(2);
        service.execute(new Producer(warehouse, Duration.ofSeconds(1)));
        service.execute(new Consumer(warehouse, Duration.ofSeconds(0)));
    }
}

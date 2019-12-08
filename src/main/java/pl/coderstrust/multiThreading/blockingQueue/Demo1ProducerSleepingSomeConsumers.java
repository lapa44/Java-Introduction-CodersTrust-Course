package pl.coderstrust.multiThreading.blockingQueue;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo1ProducerSleepingSomeConsumers {

    private static final int DEFAULT_CAPACITY = 10;

    public static void main(String[] args) {
        BlockingQueue<Integer> warehouse = new LinkedBlockingQueue<>(DEFAULT_CAPACITY);
        int consumersNumber = 3;
        ExecutorService service = Executors.newFixedThreadPool(consumersNumber + 1);
        service.execute(new Producer(warehouse, Duration.ofSeconds(1)));
        for (int i = 0; i < consumersNumber; i++) {
            service.execute(new Consumer(warehouse, Duration.ofSeconds(0)));
        }
    }
}

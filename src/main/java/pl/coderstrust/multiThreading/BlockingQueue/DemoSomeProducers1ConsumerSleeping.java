package pl.coderstrust.multiThreading.BlockingQueue;

import pl.coderstrust.multiThreading.MainBase;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class DemoSomeProducers1ConsumerSleeping extends MainBase {

    public static void main(String[] args) {
        BlockingQueue<Integer> warehouse = new LinkedBlockingQueue<>(DEFAULT_CAPACITY);
        int producersNumber = 3;
        executor = Executors.newFixedThreadPool(producersNumber + 1);
        for (int i = 0; i < producersNumber; i++) {
            executor.execute(new Producer(warehouse, false));
        }
        executor.execute(new Consumer(warehouse, true));
    }
}

package pl.coderstrust.multiThreading.BlockingQueue;

import pl.coderstrust.multiThreading.MainBase;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class DemoSomeProducersSleepingAndConsumers extends MainBase {

    public static void main(String[] args) {
        BlockingQueue<Integer> warehouse = new LinkedBlockingQueue<>(DEFAULT_CAPACITY);
        int producersNumber = 3, consumersNumber = 3;
        executor = Executors.newFixedThreadPool(producersNumber + consumersNumber);
        for (int i = 0; i < producersNumber; i++) {
            executor.execute(new Producer(warehouse, true));
        }
        for (int i = 0; i < consumersNumber; i++) {
            executor.execute(new Consumer(warehouse, false));
        }
    }
}

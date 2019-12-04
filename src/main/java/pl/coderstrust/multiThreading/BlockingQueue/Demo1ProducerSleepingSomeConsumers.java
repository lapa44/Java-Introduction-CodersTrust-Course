package pl.coderstrust.multiThreading.BlockingQueue;

import pl.coderstrust.multiThreading.MainBase;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo1ProducerSleepingSomeConsumers extends MainBase {

    public static void main(String[] args) {
        BlockingQueue<Integer> warehouse = new LinkedBlockingQueue<>(DEFAULT_CAPACITY);
        int consumersNumber = 3;
        executor = Executors.newFixedThreadPool(consumersNumber + 1);
        executor.execute(new Producer(warehouse, true));
        for (int i = 0; i < consumersNumber; i++) {
            executor.execute(new Consumer(warehouse, false));
        }
    }
}

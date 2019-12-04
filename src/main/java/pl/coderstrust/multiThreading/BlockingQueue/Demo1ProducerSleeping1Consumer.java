package pl.coderstrust.multiThreading.BlockingQueue;

import pl.coderstrust.multiThreading.MainBase;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo1ProducerSleeping1Consumer extends MainBase {

    public static void main(String[] args) {
        BlockingQueue<Integer> warehouse = new LinkedBlockingQueue<>(DEFAULT_CAPACITY);
        executor = Executors.newFixedThreadPool(2);
        executor.execute(new Producer(warehouse, true));
        executor.execute(new Consumer(warehouse, false));
    }
}

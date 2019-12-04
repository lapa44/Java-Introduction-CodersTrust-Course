package pl.coderstrust.multiThreading.ownSync;

import pl.coderstrust.multiThreading.MainBase;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executors;

public class DemoSomeProducersAndConsumersSleeping extends MainBase {

    public static void main(String[] args) {
        Queue<Integer> warehouse = new PriorityQueue<>(DEFAULT_CAPACITY);
        int producersNumber = 3, consumersNumber = 3;
        executor = Executors.newFixedThreadPool(producersNumber + consumersNumber);
        for (int i = 0; i < producersNumber; i++) {
            executor.execute(new Producer(warehouse, lock, false));
        }
        for (int i = 0; i < consumersNumber; i++) {
            executor.execute(new Consumer(warehouse, lock, true));
        }
    }
}

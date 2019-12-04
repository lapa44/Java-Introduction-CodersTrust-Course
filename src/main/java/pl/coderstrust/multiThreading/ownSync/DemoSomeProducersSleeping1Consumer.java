package pl.coderstrust.multiThreading.ownSync;

import pl.coderstrust.multiThreading.MainBase;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executors;

public class DemoSomeProducersSleeping1Consumer extends MainBase {

    public static void main(String[] args) {
        Queue<Integer> warehouse = new PriorityQueue<>(DEFAULT_CAPACITY);
        int producersNumber = 3;
        executor = Executors.newFixedThreadPool(producersNumber + 1);
        for (int i = 0; i < producersNumber; i++) {
            executor.execute(new Producer(warehouse, lock, true));
        }
        executor.execute(new Consumer(warehouse, lock, false));
    }
}

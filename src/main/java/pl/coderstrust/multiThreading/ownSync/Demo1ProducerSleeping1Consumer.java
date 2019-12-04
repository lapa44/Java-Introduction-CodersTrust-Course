package pl.coderstrust.multiThreading.ownSync;

import pl.coderstrust.multiThreading.MainBase;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executors;

public class Demo1ProducerSleeping1Consumer extends MainBase {

    public static void main(String[] args) {
        Queue<Integer> warehouse = new PriorityQueue<>(DEFAULT_CAPACITY);
        executor = Executors.newFixedThreadPool(2);
        executor.execute(new Producer(warehouse, lock, true));
        executor.execute(new Consumer(warehouse, lock, false));
    }
}

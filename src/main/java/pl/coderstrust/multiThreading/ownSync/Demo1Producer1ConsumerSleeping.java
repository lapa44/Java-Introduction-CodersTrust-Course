package pl.coderstrust.multiThreading.ownSync;

import pl.coderstrust.multiThreading.MainBase;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executors;

public class Demo1Producer1ConsumerSleeping extends MainBase {

    public static void main(String[] args) {
        Queue<Integer> warehouse = new PriorityQueue<>(DEFAULT_CAPACITY);
        executor = Executors.newFixedThreadPool(2);
        executor.execute(new Producer(warehouse, lock, false));
        executor.execute(new Consumer(warehouse, lock, true));
    }
}

package pl.coderstrust.multiThreading.ownSync;

import pl.coderstrust.multiThreading.MainBase;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.Executors;

public class Demo1ProducerSomeConsumersSleeping extends MainBase {

    public static void main(String[] args) {
        Queue<Integer> warehouse = new PriorityQueue<>(DEFAULT_CAPACITY);
        int consumersNumber = 3;
        executor = Executors.newFixedThreadPool(consumersNumber + 1);
        executor.execute(new Producer(warehouse, lock, false));
        for (int i = 0; i < consumersNumber; i++) {
            executor.execute(new Consumer(warehouse, lock, true));
        }
    }
}

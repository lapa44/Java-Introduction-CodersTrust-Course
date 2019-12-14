package pl.coderstrust.multithreading.blockingqueue;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {

    private final BlockingQueue<Integer> warehouse;
    private final Duration interval;

    public Producer(BlockingQueue<Integer> warehouse, Duration interval) {
        this.warehouse = warehouse;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
                try {
                    if(warehouse.remainingCapacity() != 0) {
                        System.out.println(Thread.currentThread().getName() + ": Producer put new item in the warehouse.");
                    }
                    else {
                            System.out.println(Thread.currentThread().getName() + ": Producer is waiting for consumer to take elements.");
                    }
                    warehouse.put(1);
                    Thread.sleep(interval.toMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}

package pl.coderstrust.multiThreading.BlockingQueue;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;

class Consumer implements Runnable {

    private final BlockingQueue<Integer> warehouse;
    private Duration interval;

    public Consumer(BlockingQueue<Integer> warehouse, Duration interval) {
        this.warehouse = warehouse;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
                try {
                    if (warehouse.isEmpty()) {
                        System.out.println(Thread.currentThread().getName() + ": Consumer is waiting for new products.");
                    }
                    warehouse.take();
                    System.out.println(Thread.currentThread().getName() + ": Consumer took element from the warehouse.");
                    Thread.sleep(interval.toMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}

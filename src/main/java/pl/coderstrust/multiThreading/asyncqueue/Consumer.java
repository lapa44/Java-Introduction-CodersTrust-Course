package pl.coderstrust.multiThreading.asyncqueue;

import java.time.Duration;
import java.util.Queue;

class Consumer implements Runnable {

    private final Queue<Integer> warehouse;
    private final Object lock;
    private final Duration interval;

    public Consumer(Queue<Integer> warehouse, Object lock, Duration interval) {
        this.warehouse = warehouse;
        this.lock = lock;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    if (warehouse.isEmpty()) {
                        System.out.println(Thread.currentThread().getName() + ": Consumer is waiting for new products.");
                        lock.wait();
                    } else {
                        warehouse.remove();
                        lock.notify();
                        System.out.println(Thread.currentThread().getName() + ": Consumer took element from the warehouse.");
                        Thread.sleep(interval.toMillis());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

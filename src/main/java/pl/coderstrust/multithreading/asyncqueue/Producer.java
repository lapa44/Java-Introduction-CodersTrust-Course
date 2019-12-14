package pl.coderstrust.multithreading.asyncqueue;

import java.time.Duration;
import java.util.Queue;

class Producer implements Runnable {

    private final Queue<Integer> warehouse;
    private final Object lock;
    private final Duration interval;

    public Producer(Queue<Integer> warehouse, Object lock, Duration interval) {
        this.warehouse = warehouse;
        this.lock = lock;
        this.interval = interval;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    if(warehouse.size() != 10) {
                        warehouse.add(1);
                        System.out.println(Thread.currentThread().getName() + ": Producer put new item in the warehouse.");
                        lock.notify();
                        Thread.sleep(interval.toMillis());
                    }
                    else {
                        System.out.println(Thread.currentThread().getName() + ": Producer is waiting for consumer to take elements.");
                        lock.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

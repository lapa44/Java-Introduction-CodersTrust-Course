package pl.coderstrust.multiThreading.blockingQueue;

import java.time.Duration;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

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
                    if(warehouse.offer(1, interval.getSeconds(), TimeUnit.SECONDS)) {
                        System.out.println(Thread.currentThread().getName() + ": Producer put new item in the warehouse.");
                    }
                    else{
                            System.out.println(Thread.currentThread().getName() + ": Producer is waiting for consumer to take elements.");
                    }
                    Thread.sleep(interval.toMillis());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}

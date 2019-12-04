package pl.coderstrust.multiThreading.ownSync;

import java.util.Queue;

public class Consumer implements Runnable {
    private Queue<Integer> warehouse;
    private final Object lock;
    private final boolean sleepFlag;
    private int interval = 1000;

    public Consumer(Queue<Integer> warehouse, Object lock, boolean sleepFlag, int interval) {
        super();
        this.warehouse = warehouse;
        this.lock = lock;
        this.sleepFlag = sleepFlag;
        this.interval = interval;
    }

    public Consumer(Queue<Integer> warehouse, Object lock, boolean sleepFlag) {
        super();
        this.warehouse = warehouse;
        this.lock = lock;
        this.sleepFlag = sleepFlag;
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
                        if (sleepFlag)
                            Thread.sleep(interval);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

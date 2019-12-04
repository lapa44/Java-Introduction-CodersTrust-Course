package pl.coderstrust.multiThreading.ownSync;

import java.util.Queue;

public class Producer implements Runnable {

    private Queue<Integer> warehouse;
    private final Object lock;
    private final boolean sleepFlag;
    private int interval = 1000;

    public Producer(Queue<Integer> warehouse, Object lock, boolean sleepFlag, int interval) {
        super();
        this.warehouse = warehouse;
        this.lock = lock;
        this.sleepFlag = sleepFlag;
        this.interval = interval;
    }

    public Producer(Queue<Integer> warehouse, Object lock, boolean sleepFlag) {
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
                    if(warehouse.size() != 10) {
                        warehouse.add(1);
                        System.out.println(Thread.currentThread().getName() + ": Producer put new item in the warehouse.");
                        lock.notify();
                        if (sleepFlag)
                            Thread.sleep(interval);
                    }
                    else {
                        System.out.println(Thread.currentThread().getName() + ": Producer is waiting for consumer to take elements.");
                        lock.wait(interval);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

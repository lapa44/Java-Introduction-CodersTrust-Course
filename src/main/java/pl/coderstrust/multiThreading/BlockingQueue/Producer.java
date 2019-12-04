package pl.coderstrust.multiThreading.BlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

    private BlockingQueue<Integer> warehouse;
    private boolean sleepFlag;
    private int interval = 1000;

    public Producer(BlockingQueue<Integer> warehouse, boolean sleepFlag, int interval) {
        super();
        this.warehouse = warehouse;
        this.sleepFlag = sleepFlag;
        this.interval = interval;
    }

    public Producer(BlockingQueue<Integer> warehouse, boolean sleepFlag) {
        super();
        this.warehouse = warehouse;
        this.sleepFlag = sleepFlag;
    }

    @Override
    public void run() {
        while (true) {
                try {
                    if(warehouse.offer(1, interval, TimeUnit.MILLISECONDS)) {
                        System.out.println(Thread.currentThread().getName() + ": Producer put new item in the warehouse.");
                        if (sleepFlag)
                            Thread.sleep(interval);
                    }
                    else {
                        System.out.println(Thread.currentThread().getName() + ": Producer is waiting for consumer to take elements.");
                            Thread.sleep(interval);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}

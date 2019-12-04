package pl.coderstrust.multiThreading.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private BlockingQueue<Integer> warehouse;
    private boolean sleepFlag;
    private int interval = 1000;

    public Consumer(BlockingQueue<Integer> warehouse, boolean sleepFlag, int interval) {
        super();
        this.warehouse = warehouse;
        this.sleepFlag = sleepFlag;
        this.interval = interval;
    }

    public Consumer(BlockingQueue<Integer> warehouse, boolean sleepFlag) {
        super();
        this.warehouse = warehouse;
        this.sleepFlag = sleepFlag;
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
                    if (sleepFlag)
                        Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
    }
}

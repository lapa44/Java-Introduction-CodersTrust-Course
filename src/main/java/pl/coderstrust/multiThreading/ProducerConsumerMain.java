package pl.coderstrust.multiThreading;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerMain {

    private static final int DEFAULT_CAPACITY = 10;
    private final static Object monitor = new Object();
    private static int x, y, z;

    public static void main(String[] args) {
        BlockingQueue<Integer> warehouse = new LinkedBlockingQueue<>(DEFAULT_CAPACITY);

        Runnable producer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (monitor) {
                        try {
                            if(warehouse.size() != DEFAULT_CAPACITY) {
                                warehouse.put(1);
                                System.out.println(Thread.currentThread().getName() + ": Producer put new item in the warehouse.");
                                monitor.notify();
                                if (z == 1)
                                    Thread.sleep(1000);
                            }
                            else {
                                System.out.println(Thread.currentThread().getName() + ": Producer is waiting for consumer to take elements.");
                                monitor.notify();
                                monitor.wait();
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Runnable consumer = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (monitor) {
                        try {
                            if (warehouse.isEmpty()) {
                                System.out.println(Thread.currentThread().getName() + ": Consumer is waiting for new products.");
                                monitor.wait();
                            } else {
                                warehouse.take();
                                System.out.println(Thread.currentThread().getName() + ": Consumer took element from the warehouse.");
                                monitor.notify();
                                if (z == 0)
                                    Thread.sleep(1000);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 1 if producer should sleep after putting element, or 0 if consumer should sleep after taking element: ");
        z = sc.nextInt();
        System.out.println("Enter number of producer and consumer threads (x y): ");
        x = sc.nextInt();
        y = sc.nextInt();
        sc.close();
        for (int i = 0; i < x; i++) {
            new Thread(producer).start();
        }
        for (int i = 0; i < y; i++) {
            new Thread(consumer).start();
        }
    }
}

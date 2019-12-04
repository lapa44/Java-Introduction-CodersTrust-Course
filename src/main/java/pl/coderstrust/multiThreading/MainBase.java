package pl.coderstrust.multiThreading;

import java.util.concurrent.ExecutorService;

abstract public class MainBase {
    protected static final int DEFAULT_CAPACITY = 10;
    protected final static Object lock = new Object();
    protected static ExecutorService executor;
}

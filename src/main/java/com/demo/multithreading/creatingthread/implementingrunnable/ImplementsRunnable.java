package com.demo.multithreading.creatingthread.implementingrunnable;

public class ImplementsRunnable implements Runnable {

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.printf("Running Thread: %s and current state is: %s%n", thread.getName(), thread.getState());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}
        System.out.printf("Running Thread: %s sleep complete and current state is: %s%n",
                thread.getName(), thread.getState());
    }
}

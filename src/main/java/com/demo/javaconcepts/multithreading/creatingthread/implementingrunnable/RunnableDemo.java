package com.demo.javaconcepts.multithreading.creatingthread.implementingrunnable;

public class RunnableDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(new ImplementsRunnable());
        System.out.printf("Before running Thread: %s and current state is: %s%n",
                thread.getName(), thread.getState());
        thread.start();
        try {
            Thread.sleep(1500);
            System.out.printf("While running Thread: %s and current state is: %s%n",
                    thread.getName(), thread.getState());
            thread.join();
        } catch (InterruptedException e) {}
        System.out.printf("After running Thread: %s and current state is: %s%n",
                thread.getName(), thread.getState());
    }
}

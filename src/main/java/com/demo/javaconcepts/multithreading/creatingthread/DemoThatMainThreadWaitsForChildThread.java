package com.demo.javaconcepts.multithreading.creatingthread;

public class DemoThatMainThreadWaitsForChildThread extends Thread {


    @Override
    public void run() {
        try {
            System.out.println("Sleeping for 3s in child thread: " + Thread.currentThread().getId());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("After sleeping from child thread: " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        DemoThatMainThreadWaitsForChildThread thread = new DemoThatMainThreadWaitsForChildThread();
        thread.start();
        System.out.println("In main thread: " + Thread.currentThread().getId());
    }
}

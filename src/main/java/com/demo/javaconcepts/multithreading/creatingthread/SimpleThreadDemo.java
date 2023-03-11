package com.demo.javaconcepts.multithreading.creatingthread;

public class SimpleThreadDemo extends Thread {

    @Override
    public void run() {
        System.out.println("In run method: " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Runnable: " + Thread.currentThread().getId()));
        thread.start();
        System.out.println("Main: " + Thread.currentThread().getId());

        // Demo that calling run method does not create a new thread
        SimpleThreadDemo demo = new SimpleThreadDemo();
        demo.run();

        // But if we call start() method then it will create a new thread
        SimpleThreadDemo demo1 = new SimpleThreadDemo();
        demo1.start();
    }
}

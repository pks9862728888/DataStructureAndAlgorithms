package com.demo.multithreading.extendingthread;

public class MultithreadingExtendingThreadDemo {

    public static void main(String[] args) {
        ExtendsThread thread = new ExtendsThread();
        System.out.printf("Before running Thread: %s and current state is: %s%n",
                thread.getName(), thread.getState());
        // We should call start() method instead of run() method, because run method does not start the thread
//        thread.run();
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

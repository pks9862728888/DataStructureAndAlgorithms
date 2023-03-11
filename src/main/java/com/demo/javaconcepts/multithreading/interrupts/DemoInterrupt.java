package com.demo.javaconcepts.multithreading.interrupts;

public class DemoInterrupt extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(Thread.currentThread().getState() + " " + Thread.currentThread().isInterrupted());
                break;
            }
        }
    }

    public static void main(String[] args) {
        DemoInterrupt obj = new DemoInterrupt();
        obj.start();
        // Calling interrupt on a running thread throws interrupted exception
        obj.interrupt();
        // Calling interrupt on a dead thread does nothing
        obj.interrupt();
        obj.interrupt();
        obj.interrupt();
        obj.interrupt();
    }
}

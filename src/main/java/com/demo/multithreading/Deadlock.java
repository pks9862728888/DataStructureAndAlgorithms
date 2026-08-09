package com.demo.multithreading;

import lombok.Getter;

public class Deadlock {

  @Getter
  private final Object lock1 = new Object();
  @Getter
  private final Object lock2 = new Object();

  public static void main(String[] args) throws InterruptedException {
    Deadlock deadlock = new Deadlock();
    Thread t1 = new Thread(() -> {
      synchronized (deadlock.getLock1()) {
        // do some work
        System.out.println("got lock1");
        synchronized (deadlock.getLock2()) {
          // do some work
          System.out.println("doing final work t1");
        }
      }
    });
    Thread t2 = new Thread(() -> {
      synchronized (deadlock.getLock2()) {
        System.out.println("got lock2");
        synchronized (deadlock.getLock1()) {
          System.out.println("doing final work t2");
        }
      }
    });

    t1.start();
    t2.start();
    t1.join();
    t2.join();
  }
}

package com.demo.multithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

  private final Semaphore semaphore = new Semaphore(2);

  public static void main(String[] args) throws InterruptedException {
    SemaphoreDemo sd = new SemaphoreDemo();

    for (int i = 0; i < 5; i++) {
      int finalI = i;
      new Thread(() -> {
        try {
          sd.semaphore.acquire();
          System.out.println("Acquired Semaphore: " + finalI);
          Thread.sleep(2000);
        } catch (InterruptedException e) {
        } finally {
          System.out.println("Released Semaphore: " + finalI);
          sd.semaphore.release();
          sd.semaphore.acquireUninterruptibly();
        }
      }).start();
    }
    Thread.sleep(20000);
  }
}

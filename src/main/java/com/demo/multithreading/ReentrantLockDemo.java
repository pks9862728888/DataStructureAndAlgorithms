package com.demo.multithreading;

import lombok.Getter;

public class ReentrantLockDemo {

  @Getter
  private final Object lock = new Object();

  public static void main(String[] args) {
    ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();

    // since both the locks are from same thread, java allows it
    synchronized (reentrantLockDemo.getLock()) {
      System.out.println("Inside first lock");
      synchronized (reentrantLockDemo.getLock()) {
        System.out.println("Inside second lock");
      }
    }
  }
}

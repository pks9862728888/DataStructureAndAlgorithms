package com.interviewconcepts.designpatterns.creational.singleton;

import java.io.Serializable;

public class Singleton implements Serializable {

  private static transient Singleton instance;

  private Singleton() {
  }

  public Singleton getInstance() {
    if (instance == null) {
      synchronized (Singleton.class) {
        if (instance == null) {
          instance = new Singleton();
        }
      }
    }
    return instance;
  }
}

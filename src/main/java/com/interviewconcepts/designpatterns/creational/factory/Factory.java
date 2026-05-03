package com.interviewconcepts.designpatterns.creational.factory;

public class Factory {

  public static IDemoInterface build(String type) {
    switch (type) {
      case "1":
        // return object of type IDemoInterface 1
      case "2":
        // return object of type IDemoInterface 2
      default:
        throw new IllegalArgumentException("Cant build");
    }
  }
}

package com.interviewconcepts.designpatterns.creational.builder;

public class BuilderClassDemo {

  public static void main(String[] args) {
    BuilderClass bc = new BuilderClass.Builder()
        .name("Test")
        .score(100)
        .build();
    System.out.printf("bc");
  }
}

package com.interviewconcepts.designpatterns.creational.prototype;

public class ShapePrototype {

  private IShape shape1 = new Shape1();

  public IShape createShape() throws CloneNotSupportedException {
    return shape1.clone();
  }
}

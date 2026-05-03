package com.interviewconcepts.designpatterns.creational.prototype;

public class DemoPrototype {

  public static void main(String[] args) throws CloneNotSupportedException {
    ShapePrototype shapePrototype = new ShapePrototype();
    IShape shape1 = shapePrototype.createShape();
    System.out.println(shape1);

    IShape shape2 = shapePrototype.createShape();
    System.out.println(shape2);

    System.out.println(shape1 == shape2);
    System.out.println(shape1.getValues() == shape2.getValues());
  }
}

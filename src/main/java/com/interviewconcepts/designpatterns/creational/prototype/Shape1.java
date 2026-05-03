package com.interviewconcepts.designpatterns.creational.prototype;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
public class Shape1 implements IShape {
  private List<String> values = List.of("Ram", "Sam");

  @Override
  public IShape clone() throws CloneNotSupportedException {
    Shape1 shape1 = (Shape1) super.clone();
    shape1.values = new ArrayList<>(this.values); // perform deep copy
    return shape1;
  }
}

package com.interviewconcepts.designpatterns.creational.prototype;

import java.util.List;

public interface IShape extends Cloneable {

  IShape clone() throws CloneNotSupportedException;

  List<String> getValues();

}

package com.interviewconcepts.designpatterns.creational.abstractfactory;

public class ConcreteFactory2 extends AbstractFactory {

  @Override
  IPizza prepare(String type) {
    // each concrete factory will have its own way of constructing pizza
    return null;
  }
}

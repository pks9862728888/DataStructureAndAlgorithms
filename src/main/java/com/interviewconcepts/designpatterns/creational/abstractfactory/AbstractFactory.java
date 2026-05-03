package com.interviewconcepts.designpatterns.creational.abstractfactory;

import lombok.Getter;

@Getter
public abstract class AbstractFactory {
  protected String name;

  abstract IPizza prepare(String type);

}

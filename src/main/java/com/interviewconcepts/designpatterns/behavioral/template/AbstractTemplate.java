package com.interviewconcepts.designpatterns.behavioral.template;

public abstract class AbstractTemplate {

  public final void bake() {
    // do something
    // do another think
    hook();
  }

  private void hook() {
    // allow subclass to implement the hook and add behavior
  }
}

package com.demo.javaconcepts.inheritance.overriding;

public class VisibilityModifierInAbstraction extends AbstractClass {

    @Override
    public void doSomething() {}  // Increasing the visibility is allowed

//    @Override
//    private void doSomething() {}  // Decreasing the visibility is not allowed

}

abstract class AbstractClass {

    protected abstract void doSomething();

}

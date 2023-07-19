package com.demo.javaconcepts.inheritance.overriding;

public class VisibilityModifierInInheritance extends AbstractClass1 {

    @Override
    public void doSomething() {}  // Increasing the visibility is allowed

//    @Override
//    private void doSomething() {}  // Decreasing the visibility is not allowed

}

class AbstractClass1 {

    protected void doSomething() {}

}

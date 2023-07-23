package com.demo.javaconcepts.oca8.inheritance;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class InheritanceDemo extends Parent {

    @Override
    public void doSomething() {}

    /**
     * CONCEPT:
     * While overriding methods, we are not allowed to decrease visibility of method
     */
//    @Override
//    private void doSomething() {}
}

class Parent {

    protected void doSomething() {}

}

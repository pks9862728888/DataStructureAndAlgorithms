package com.demo.javaconcepts.inheritance;

public class InterfaceDemo implements Int1, Int2 {

    // If same default methods are available from 2 interface then we will have to provide impl for the method
    // For static methods we will not have to do anything since static methods does not belong to object
    @Override
    public void doSomething() {
        System.out.println("Child");
    }

}

interface Int1 {

    default void doSomething() {
        System.out.println("Int1");
    }

    static void doAnotherThing() {
        System.out.println("Int1 static");
    }
}

interface Int2 {
    default void doSomething() {
        System.out.println("Int2");
    }

    static void doAnotherThing() {
        System.out.println("Int2 static");
    }
}

package com.demo.javaconcepts.functionalinterface;

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {
        FunctionalInterfaceI obj = new FunctionalInterfaceI() {
            @Override
            public void bark() {
                System.out.println("Dogs bark! Don't be a dog!");
            }
        };
        FunctionalInterfaceI obj1 = new FunctionalInterfaceI() {
            @Override
            public void bark() {
                System.out.println("Dogs bark! Don't be a dog!");
            }
        };

        System.out.println(obj.getClass());
        System.out.println(obj1.getClass());
        System.out.println(FunctionalInterfaceDemo.class);
    }
}

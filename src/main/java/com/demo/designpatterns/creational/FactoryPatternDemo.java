package com.demo.designpatterns.creational;

public class FactoryPatternDemo {

    /**
     * The Factory pattern promotes loose coupling by separating
     * the object creation logic from the client code.
     * It allows for flexible and extensible code,
     * as new product classes can be added to the system without modifying existing client code.
     * Use case:
     * - Object creation with complex initialization
     * - Dependency injection
     * - Dynamic object creation
     * - Polymorphic object creation
     * - Decoupling client code from concrete implementations
     * - Testing and mocking
     */
    public static void main(String[] args) {
        Car ferrari = CarFactory.getCar(CarFactory.FERRARI);
        ferrari.drive();

        Car audi = CarFactory.getCar(CarFactory.AUDI);
        audi.drive();
    }
}

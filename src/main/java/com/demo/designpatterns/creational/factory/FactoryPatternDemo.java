package com.demo.designpatterns.creational.factory;

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
     * Difference with Abstract Factory pattern:
     * - The Factory pattern is used to create objects of a single type or a hierarchy of related types,
     *   while the Abstract Factory pattern is used to create families of related objects.
     * - The Factory pattern encapsulates the creation logic in a single component,
     * while the Abstract Factory pattern provides multiple factory implementations for different families of objects.
     */
    public static void main(String[] args) {
        Car ferrari = CarFactory.getCar(CarFactory.FERRARI);
        ferrari.drive();

        Car audi = CarFactory.getCar(CarFactory.AUDI);
        audi.drive();
    }
}

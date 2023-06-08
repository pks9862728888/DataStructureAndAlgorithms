package com.demo.designpatterns.creational;

public class CarFactory {

    public static final String AUDI = "AUDI";
    public static final String FERRARI = "FERRARI";

    public static Car getCar(String carType) {
        switch (carType) {
            case AUDI:
                return new AudiCar();
            case FERRARI:
                return new FerrariCar();
            default:
                throw new IllegalArgumentException("Unknown carType!");
        }
    }
}

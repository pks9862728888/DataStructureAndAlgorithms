package com.demo.designpatterns.creational;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FerrariCar implements Car {
    @Override
    public void drive() {
        log.info("Driving Ferrari!");
    }
}

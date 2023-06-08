package com.demo.designpatterns.creational;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AudiCar implements Car {
    @Override
    public void drive() {
        log.info("Driving Audi!");
    }
}

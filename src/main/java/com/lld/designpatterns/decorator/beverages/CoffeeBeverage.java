package com.lld.designpatterns.decorator.beverages;

import java.util.LinkedHashMap;
import java.util.Map;

public class CoffeeBeverage implements Beverage {

    @Override
    public double cost() {
        return 20;
    }

    @Override
    public String description() {
        return "Coffee";
    }

    @Override
    public Map<String, Double> costBreakdown() {
        Map<String, Double> map = new LinkedHashMap<>();
        map.put(description(), cost());
        return map;
    }
}

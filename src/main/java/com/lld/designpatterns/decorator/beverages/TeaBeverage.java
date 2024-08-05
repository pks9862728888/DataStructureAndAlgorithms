package com.lld.designpatterns.decorator.beverages;

import java.util.LinkedHashMap;
import java.util.Map;

public class TeaBeverage implements Beverage {

    @Override
    public double cost() {
        return 10;
    }

    @Override
    public String description() {
        return "Tea";
    }

    @Override
    public Map<String, Double> costBreakdown() {
        Map<String, Double> map = new LinkedHashMap<>();
        map.put(description(), cost());
        return map;
    }
}

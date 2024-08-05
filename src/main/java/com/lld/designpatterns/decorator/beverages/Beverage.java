package com.lld.designpatterns.decorator.beverages;

import java.util.Map;

public interface Beverage {

    double cost();
    String description();
    Map<String, Double> costBreakdown();

}

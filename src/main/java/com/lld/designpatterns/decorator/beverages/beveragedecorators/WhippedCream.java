package com.lld.designpatterns.decorator.beverages.beveragedecorators;

import com.lld.designpatterns.decorator.beverages.Beverage;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class WhippedCream implements CondimentsBeverageDecorator {
    public static final double FIXED_COST = 0.10;
    private final Beverage beverage;

    @Override
    public double cost() {
        return FIXED_COST + beverage.cost();
    }

    @Override
    public String description() {
        return "Whipped Cream";
    }

    @Override
    public Map<String, Double> costBreakdown() {
        Map<String, Double> costBreakdown = beverage.costBreakdown();
        costBreakdown.put(description(), FIXED_COST);
        return costBreakdown;
    }
}

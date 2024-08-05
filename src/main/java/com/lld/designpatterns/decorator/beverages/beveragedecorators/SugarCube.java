package com.lld.designpatterns.decorator.beverages.beveragedecorators;

import com.lld.designpatterns.decorator.beverages.Beverage;
import lombok.RequiredArgsConstructor;

import java.util.Map;

@RequiredArgsConstructor
public class SugarCube implements CondimentsBeverageDecorator {
    private final Beverage beverage;
    private final int quantity;

    @Override
    public double cost() {
        return getBaseCost() + beverage.cost();
    }

    private double getBaseCost() {
        return 0.5 * quantity;
    }

    @Override
    public String description() {
        return String.format("%s [%s]", "Sugar Cubes", quantity);
    }

    @Override
    public Map<String, Double> costBreakdown() {
        Map<String, Double> costBreakdown = beverage.costBreakdown();
        costBreakdown.put(description(), getBaseCost());
        return costBreakdown;
    }
}

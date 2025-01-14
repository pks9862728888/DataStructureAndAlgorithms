package com.lld.designpatterns.behavioral.visitor.visitors;

import com.lld.designpatterns.behavioral.visitor.elements.CarElement;
import com.lld.designpatterns.behavioral.visitor.elements.ElementOrder;
import com.lld.designpatterns.behavioral.visitor.elements.TruckElement;
import com.lld.designpatterns.behavioral.visitor.elements.TwoWheelerElement;

public class WeightVisitor implements IVisitor {

    double weight = 0;

    @Override
    public void visit(TwoWheelerElement twoWheelerElement) {
        weight += 5;
        System.out.printf("Visited: %s weight: %s \n", twoWheelerElement, weight);
    }

    @Override
    public void visit(TruckElement truckElement) {
        weight += 50;
        System.out.printf("Visited: %s weight: %s \n", truckElement, weight);
    }

    @Override
    public void visit(CarElement carElement) {
        weight += 20;
        System.out.printf("Visited: %s weight: %s \n", carElement, weight);
    }

    @Override
    public void visit(ElementOrder elementOrder) {
        System.out.printf("Visited: %s weight: %s\n", elementOrder, weight);
    }

    public double getWeight() {
        return weight;
    }
}

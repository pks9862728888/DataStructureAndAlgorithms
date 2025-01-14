package com.lld.designpatterns.behavioral.visitor.visitors;

import com.lld.designpatterns.behavioral.visitor.elements.CarElement;
import com.lld.designpatterns.behavioral.visitor.elements.ElementOrder;
import com.lld.designpatterns.behavioral.visitor.elements.TruckElement;
import com.lld.designpatterns.behavioral.visitor.elements.TwoWheelerElement;

public class AssetPriceVisitor implements IVisitor {

    double price = 0;

    @Override
    public void visit(TwoWheelerElement twoWheelerElement) {
        price += 5;
        System.out.printf("Visited: %s price: %s \n", twoWheelerElement, price);
    }

    @Override
    public void visit(TruckElement truckElement) {
        price += 50;
        System.out.printf("Visited: %s price: %s \n", truckElement, price);
    }

    @Override
    public void visit(CarElement carElement) {
        price += 20;
        System.out.printf("Visited: %s price: %s \n", carElement, price);
    }

    @Override
    public void visit(ElementOrder elementOrder) {
        System.out.printf("Visited: %s price: %s\n", elementOrder, price);
    }

    public double getPrice() {
        return price;
    }
}

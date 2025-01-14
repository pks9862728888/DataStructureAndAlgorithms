package com.lld.designpatterns.behavioral.visitor;

import com.lld.designpatterns.behavioral.visitor.elements.CarElement;
import com.lld.designpatterns.behavioral.visitor.elements.ElementOrder;
import com.lld.designpatterns.behavioral.visitor.elements.TruckElement;
import com.lld.designpatterns.behavioral.visitor.elements.TwoWheelerElement;
import com.lld.designpatterns.behavioral.visitor.visitors.AssetPriceVisitor;
import com.lld.designpatterns.behavioral.visitor.visitors.WeightVisitor;

public class VisitorDemoMain {

    /**
     * Visitor pattern: This pattern abstracts away the complexity by moving code out of the entities
     * In below example, if we need to calculate something we can create another visitor and only change there
     * no need to touch all implementations
     * It favours open-closed principle.
     */
    public static void main(String[] args) {
        ElementOrder order = new ElementOrder();
        order.addElement(new CarElement());
        order.addElement(new TruckElement());
        order.addElement(new TwoWheelerElement());

        // Calculate asset price
        AssetPriceVisitor assetPriceVisitor = new AssetPriceVisitor();
        order.accept(assetPriceVisitor);
        System.out.printf("Price: %s%n", assetPriceVisitor.getPrice());
        System.out.println();

        // Calculate weight
        WeightVisitor weightVisitor = new WeightVisitor();
        order.accept(weightVisitor);
        System.out.printf("Weight: %s%n", weightVisitor.getWeight());
        System.out.println();
    }
}

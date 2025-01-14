package com.lld.designpatterns.behavioral.visitor.visitors;

import com.lld.designpatterns.behavioral.visitor.elements.CarElement;
import com.lld.designpatterns.behavioral.visitor.elements.ElementOrder;
import com.lld.designpatterns.behavioral.visitor.elements.TruckElement;
import com.lld.designpatterns.behavioral.visitor.elements.TwoWheelerElement;

public interface IVisitor {

    void visit(TwoWheelerElement carElement);

    void visit(TruckElement truckElement);

    void visit(CarElement carElement);

    void visit(ElementOrder elementOrder);
}

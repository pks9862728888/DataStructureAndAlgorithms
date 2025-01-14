package com.lld.designpatterns.behavioral.visitor.elements;

import com.lld.designpatterns.behavioral.visitor.visitors.IVisitor;

public class TwoWheelerElement implements IElement {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}

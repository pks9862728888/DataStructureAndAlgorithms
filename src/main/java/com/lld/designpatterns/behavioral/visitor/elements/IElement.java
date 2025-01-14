package com.lld.designpatterns.behavioral.visitor.elements;

import com.lld.designpatterns.behavioral.visitor.visitors.IVisitor;

public interface IElement {

    void accept(IVisitor visitor);
}

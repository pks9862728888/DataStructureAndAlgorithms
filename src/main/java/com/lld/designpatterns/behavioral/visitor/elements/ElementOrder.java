package com.lld.designpatterns.behavioral.visitor.elements;

import com.lld.designpatterns.behavioral.visitor.visitors.IVisitor;

import java.util.ArrayList;
import java.util.List;

public class ElementOrder implements IElement {

    private List<IElement> elementsList = new ArrayList<>();

    public void addElement(IElement element) {
        elementsList.add(element);
    }

    @Override
    public void accept(IVisitor visitor) {
        System.out.println("Visiting all elements...");
        for (IElement element : elementsList) {
            element.accept(visitor);
        }
    }
}

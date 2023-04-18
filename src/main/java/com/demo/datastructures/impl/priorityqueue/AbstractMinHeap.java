package com.demo.datastructures.impl.priorityqueue;

import java.util.NoSuchElementException;

public abstract class AbstractMinHeap<T> implements PQ<T> {

    public abstract T removeMin() throws NoSuchElementException;

    public abstract T getMin() throws NoSuchElementException;

}

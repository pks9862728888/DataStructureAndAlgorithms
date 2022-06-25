package com.demo.datastructures.priorityQueue;

import java.util.NoSuchElementException;

public abstract class AbstractMinHeap<T> implements PQ<T> {

    abstract T removeMin() throws NoSuchElementException;
    abstract T getMin() throws NoSuchElementException;

}

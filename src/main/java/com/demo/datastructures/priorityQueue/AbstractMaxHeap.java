package com.demo.datastructures.priorityQueue;

import java.util.NoSuchElementException;

public abstract class AbstractMaxHeap<T> implements PQ<T> {

    public abstract T removeMax() throws NoSuchElementException;
    public abstract T getMax() throws NoSuchElementException;

}

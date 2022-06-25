package com.demo.datastructures.priorityQueue;

import java.util.NoSuchElementException;

public abstract class AbstractMaxHeap<T> implements PQ<T> {

    abstract T removeMax() throws NoSuchElementException;
    abstract T getMax() throws NoSuchElementException;

}

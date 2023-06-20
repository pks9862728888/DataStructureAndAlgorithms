package com.demo.datastructures.impl.heaps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HeapNode<T extends Comparable<T>> implements Comparable<HeapNode<T>> {
    private T value;
    private int priority;

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public int compareTo(HeapNode<T> o) {
        return o.getValue().compareTo(value);
    }
}

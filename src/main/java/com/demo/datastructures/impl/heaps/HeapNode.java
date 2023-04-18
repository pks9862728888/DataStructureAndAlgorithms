package com.demo.datastructures.impl.heaps;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public
class HeapNode<T> {
    private T value;
    private int priority;
}

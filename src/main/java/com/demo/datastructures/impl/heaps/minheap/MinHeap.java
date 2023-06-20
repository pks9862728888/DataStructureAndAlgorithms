package com.demo.datastructures.impl.heaps.minheap;

import com.demo.datastructures.impl.heaps.HeapNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class MinHeap<T extends Comparable<T>> {

    private int capacity;
    private int size;
    private HeapNode<T>[] heap;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = (HeapNode<T>[]) new HeapNode[capacity];
    }

    public void add(int priority, T value) {
        if (size() == capacity) {
            doubleCapacity();
        }

        // Add to last of heap
        HeapNode<T> heapNode = new HeapNode<>(value, priority);
        heap[size++] = heapNode;

        // Heapify: Move the node to correct position based on priority
        minHeapify(size - 1);
    }

    private void minHeapify(int currIdx) {
        while (currIdx != 0 && heap[currIdx].getPriority() < heap[parentIdx(currIdx)].getPriority()) {
            swapNodes(currIdx, parentIdx(currIdx));
            currIdx = parentIdx(currIdx);
        }
    }

    public T peek() {
        if (size > 0) {
            return heap[0].getValue();
        }
        return null;
    }

    public T poll() {
        if (size > 0) {
            // Store first element
            T ele = heap[0].getValue();

            // Swap first element with last element & decrement size
            swapNodes(0, size-- - 1);

            // Min heapify (iterative): compare with child and replace with min of child nodes
            int currIdx = 0;
            while (currIdx < size) {
                int leftChildIdx = leftChildIdx(currIdx);
                int rightChildIdx = rightChildIdx(currIdx);
                int smallest = currIdx;
                if (leftChildIdx < size && heap[smallest].compareTo(heap[leftChildIdx]) < 0) {
                    smallest = leftChildIdx;
                }
                if (rightChildIdx < size && heap[smallest].compareTo(heap[rightChildIdx]) < 0) {
                    smallest = rightChildIdx;
                }
                if (smallest != currIdx) {
                    swapNodes(smallest, currIdx);
                    currIdx = smallest;
                } else {
                    break;
                }
            }

            // Return the value which was removed
            return ele;
        }
        return null;
    }

    public void increasePriority(int curIdx, int newPriority) {
        validateIdxBoundElseThrow(curIdx);

        // Increase priority
        HeapNode<T> currNode = heap[curIdx];
        currNode.setPriority(newPriority);

        // Re-heapify with parent node
        while (curIdx != 0 && heap[curIdx].compareTo(heap[parentIdx(curIdx)]) < 0) {
            swapNodes(curIdx, parentIdx(curIdx));
            curIdx = parentIdx(curIdx);
        }
    }

    public T deleteAtIdx(int curIdx) {
        validateIdxBoundElseThrow(curIdx);

        // Decrement priority so that it moves to the top of heap
        HeapNode<T> currNode = heap[curIdx];
        currNode.setPriority(Integer.MIN_VALUE);
        minHeapify(curIdx);

        // Call poll() so that root node is removed
        poll();

        return currNode.getValue();
    }

    /**
     * Used to build heap for non-heap array
     * TC: O(n) - refer GFG lecture
     */
    public void buildHeap() {
        // Call min-heapify of the bottom most, right most internal node
        // Assumption: leaf nodes are already heapified
        for (int i = (size - 2) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }

    private void swapNodes(int idx1, int idx2) {
        HeapNode<T> temp = heap[idx1];
        heap[idx1] = heap[idx2];
        heap[idx2] = temp;
    }

    public int parentIdx(int currIdx) {
        return Math.floorDiv(currIdx - 1, 2);
    }

    public int leftChildIdx(int currIdx) {
        return 2 * currIdx + 1;
    }

    public int rightChildIdx(int currIdx) {
        return 2 * currIdx + 2;
    }

    private void doubleCapacity() {
        int maxCapacity = 2 * capacity;
        heap = Arrays.copyOf(heap, maxCapacity);
        capacity = maxCapacity;
    }

    public int size() {
        return this.size;
    }

    private void validateIdxBoundElseThrow(int curIdx) {
        if (curIdx >= size) {
            throw new IllegalStateException("curIdx should be < size: " + size);
        }
    }

    @Override
    public String toString() {
        return "[" + IntStream.range(0, size)
                .mapToObj(idx -> heap[idx].getValue())
                .map(String::valueOf)
                .collect(Collectors.joining(", ")) + "]";
    }
}

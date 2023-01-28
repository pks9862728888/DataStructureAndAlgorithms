package com.demo.algorithms.sorting;

import com.demo.datastructures.priorityQueue.AbstractMaxHeap;
import com.demo.datastructures.priorityQueue.AbstractMinHeap;
import com.demo.datastructures.priorityQueue.MaxHeapPQ;
import com.demo.datastructures.priorityQueue.MinHeapPQ;

import java.util.Arrays;
import java.util.Objects;

public class HeapSort {

    public static void main(String[] args) {
        // Heap sort ascending order
        int arr[] = getArr();
        heapSort(arr, true);
        System.out.println("SORTED IN ASCENDING ORDER: " + Arrays.toString(arr));

        // Heap sort descending order
        arr = getArr();
        heapSort(arr, false);
        System.out.println("SORTED IN DESCENDING ORDER: " + Arrays.toString(arr));

        // Heap sort efficient approach
        arr = getArr();
        heapSortInPlace(arr, true);
        System.out.println("SORTED IN ASCENDING ORDER IN-PLACE: " + Arrays.toString(arr));

        // Heap sort descending order
        arr = getArr();
        heapSortInPlace(arr, false);
        System.out.println("SORTED IN DESCENDING ORDER IN-PLACE: " + Arrays.toString(arr));
    }

    /**
     * TC: O(n log n)
     * AS: O(1)
     */
    private static void heapSortInPlace(int[] arr, boolean isAscending) {
        if (Objects.isNull(arr) || arr.length <= 1) {
            return;
        }
        if (isAscending) {
            sortAscendingUsingMaxHeap(arr);
        } else {
            sortDescendingUsingMinHeap(arr);
        }
    }

    private static void sortDescendingUsingMinHeap(int[] arr) {
        // Generate Min Heap in place TC (n log n)
        for (int i = 1; i < arr.length; i++) {
            int childIdx = i;
            int parentIdx = (childIdx - 1) / 2;

            while (parentIdx >= 0 && arr[parentIdx] > arr[childIdx]) {
                swap(arr, parentIdx, childIdx);

                childIdx = parentIdx;
                parentIdx = (childIdx - 1) / 2;
            }
        }

        // Sort in descending order in-place (TC - O(n log n))
        int endIdx = arr.length - 1;
        while (endIdx > 0) {
            // Swap with the heap top
            swap(arr, 0, endIdx);

            // Re-heap
            int parentIdx = 0;
            int childIdx1 = 1;
            int childIdx2 = 2;

            while (true) {
                int swapIdx;
                if (childIdx1 < endIdx && childIdx2 < endIdx) {
                    swapIdx = arr[childIdx1] < arr[childIdx2] ? childIdx1 : childIdx2;
                } else if (childIdx1 < endIdx && childIdx2 >= endIdx) {
                    swapIdx = childIdx1;
                } else {
                    break;
                }

                if (arr[parentIdx] > arr[swapIdx]) {
                    swap(arr, parentIdx, swapIdx);
                    parentIdx = swapIdx;
                } else {
                    break;
                }

                childIdx1 = parentIdx * 2 + 1;
                childIdx2 = parentIdx * 2 + 2;
            }

            endIdx--;
        }
    }

    private static void sortAscendingUsingMaxHeap(int[] arr) {
        // Generate Max Heap in place TC (n log n)
        for (int i = 1; i < arr.length; i++) {
            int childIdx = i;
            int parentIdx = (childIdx - 1) / 2;

            while (parentIdx >= 0 && arr[parentIdx] < arr[childIdx]) {
                swap(arr, parentIdx, childIdx);

                childIdx = parentIdx;
                parentIdx = (childIdx - 1) / 2;
            }
        }

        // Sort in ascending order in-place (TC - O(n log n))
        int endIdx = arr.length - 1;
        while (endIdx > 0) {
            // Swap with top of heap
            swap(arr, 0, endIdx);

            // Re-heap
            int parentIdx = 0;
            int childIdx1 = 1;
            int childIdx2 = 2;

            while (true) {
                int swapIdx;
                if (childIdx1 < endIdx && childIdx2 < endIdx) {
                    swapIdx = arr[childIdx1] > arr[childIdx2] ? childIdx1 : childIdx2;
                } else if (childIdx1 < endIdx && childIdx2 >= endIdx) {
                    swapIdx = childIdx1;
                } else {
                    break;
                }

                if (arr[parentIdx] < arr[swapIdx]) {
                    swap(arr, parentIdx, swapIdx);
                    parentIdx = swapIdx;
                } else {
                    break;
                }

                childIdx1 = parentIdx * 2 + 1;
                childIdx2 = parentIdx * 2 + 2;
            }

            endIdx--;
        }
    }

    /**
     * TC: O(n log n)
     * AS: O(n)
     */
    private static void heapSort(int[] arr, boolean isAscending) {
        if (isAscending) {
            sortByMinHeap(arr);
        } else {
            sortByMaxHeap(arr);
        }
    }

    private static void sortByMaxHeap(int[] arr) {
        AbstractMaxHeap<Integer> maxHeap = new MaxHeapPQ<>();
        Arrays.stream(arr)
                .forEach(e -> maxHeap.add(e, e));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = maxHeap.removeMax();
        }
    }

    private static void sortByMinHeap(int[] arr) {
        AbstractMinHeap<Integer> maxHeap = new MinHeapPQ<>();
        Arrays.stream(arr)
                .forEach(e -> maxHeap.add(e, e));
        for (int i = 0; i < arr.length; i++) {
            arr[i] = maxHeap.removeMin();
        }
    }

    private static int[] getArr() {
        return new int[] {3, 2, 7, 9, 1, 99, 5, 1, 0, 10};
    }

    private static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

}

package com.demo.algorithms.sorting;

import java.util.Arrays;

/**
 * TC: O (n * n)
 */
public class SelectionSort {
    static class Node {
        String name;
        int age;
        public Node(String name, int age) {
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public Node copy() {
           return new Node(this.name, this.age);
        }
    }

    public static void main(String[] args) {
        // Unstable selection sort
        Node[] arr1 = {new Node("A", 13), new Node("Z", 13), new Node("B", 2)};
        System.out.println("Before" + Arrays.toString(arr1));
        unstableSelectionSort(arr1);
        System.out.println(Arrays.toString(arr1));

        // Stable selection sort
        Node[] arr2 = {new Node("A", 13), new Node("Z", 13), new Node("B", 2)};
        stableSelectionSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * Stable selection sort
     */
    private static void stableSelectionSort(Node[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].age > arr[j].age) {
                    Node temp = arr[j];
                    int k = j;
                    while (k > i) {
                        arr[k] = arr[k - 1];
                        k--;
                    }
                    arr[i] = temp;
                }
            }
        }
    }

    /**
     * Unstable selection sort
     */
    private static void unstableSelectionSort(Node[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].age > arr[j].age) {
                    Node temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}


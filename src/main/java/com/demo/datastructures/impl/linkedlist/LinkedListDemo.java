package com.demo.datastructures.impl.linkedlist;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        System.out.println("Insert--------------------");
        linkedList.insert(0, 10);
        linkedList.insert(1, 32);
        linkedList.insert(2, 2);
        linkedList.insert(3, 42);
        linkedList.insert(4, 12);
        linkedList.mergeSort();
        linkedList.printRecursively();
//        System.out.println(linkedList);
//        System.out.println(linkedList.getLast());
//
//        System.out.println("Delete-------------------");
//        linkedList.deleteNode(3);
//        System.out.println(linkedList);
//        System.out.println(linkedList.getLast());
//        linkedList.deleteNode(2);
//        linkedList.deleteNode(0);
//        System.out.println(linkedList);
//        System.out.println(linkedList.getLast());

//        LinkedList<Integer> l1 = new LinkedList<>();
//        l1.insertRecursively(0, 1);
//        l1.insertRecursively(1, 2);
//        l1.insertRecursively(2, 2);
//        l1.insertRecursively(3, 4);
//        l1.reverseRecursively();
//        l1.printRecursively();
//        System.out.println(l1.isPalindrome());
//        l1.printRecursively();
//
//        // Deleting
//        System.out.println("DN: " + l1.deleteRecursively(4));
//        l1.printRecursively();
//        System.out.println(l1.getLast());
//        System.out.println("-------------------------");
//        System.out.println("DN: " + l1.deleteRecursively(3));
//        l1.printRecursively();
//        System.out.println(l1.getLast());
//        System.out.println("-------------------------");
//        System.out.println("DN: " + l1.deleteRecursively(1));
//        l1.printRecursively();
//        System.out.println(l1.getLast());
////        System.out.println(l1.deleteRecursively(1));
//        System.out.println("-------------------------");
//        System.out.println("DN: " + l1.deleteRecursively(0));
//        l1.printRecursively();
//        System.out.println(l1.getLast());
//        System.out.println(l1.size());
//
//        LinkedList<Integer> l2 = new LinkedList<>();
//        l2.insert(0, 1);
//        l2.insert(1, 2);
//        l2.insert(2, 3);
//        l2.insert(3, 2);
//        l2.insert(4, 1);
//        System.out.println(l2.isPalindrome());

//        LinkedList<Integer> l1 = new LinkedList<>();
//        l1.insertRecursively(0, 1);
//        l1.insertRecursively(1, 2);
//        l1.insertRecursively(2, 3);
//        l1.insertRecursively(3, 4);
//        l1.insertRecursively(4, 5);
//        l1.insertRecursively(5, 6);
//        l1.insertRecursively(6, 7);
//        l1.kReverse(3);
//        l1.printRecursively();
    }
}

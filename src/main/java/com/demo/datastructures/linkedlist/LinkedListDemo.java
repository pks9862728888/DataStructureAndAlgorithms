package com.demo.datastructures.linkedlist;

public class LinkedListDemo {

    public static void main(String[] args) {
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        System.out.println("Insert--------------------");
//        linkedList.insert(0, 1);
//        linkedList.insert(1, 3);
//        linkedList.insert(1, 2);
//        linkedList.insert(3, 4);
//        linkedList.insert(9, 12);
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

        LinkedList<Integer> l1 = new LinkedList<>();
        l1.insert(0, 1);
        l1.insert(1, 2);
        l1.insert(2, 2);
        l1.insert(3, 1);
        System.out.println(l1.isPalindrome());

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.insert(0, 1);
        l2.insert(1, 2);
        l2.insert(2, 3);
        l2.insert(3, 2);
        l2.insert(4, 1);
        System.out.println(l2.isPalindrome());
    }
}

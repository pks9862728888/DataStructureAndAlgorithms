package com.demo.stack;

public class StackDemo {

    public static void main(String[] args) {
//        StackUsingArrayList<Integer> stack = new StackUsingArrayList<>();
//        StackUsingArray<Integer> stack = new StackUsingArray<>();
        StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();
        stack.push(10);
        System.out.println("SIZE: " + stack.size());
        stack.push(20);
        System.out.println("SIZE: " + stack.size());
        System.out.println("PEEK: " + stack.peek());
        System.out.println("POP: " + stack.pop());
        stack.pop();
        System.out.println("IS EMPTY: " + stack.isEmpty());
    }
}

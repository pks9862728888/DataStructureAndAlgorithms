package com.demo.datastructures.linkedlist;

public class LinkedList<T> {

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public int insert(int pos, T data) {
        Node<T> temp = new Node<>(data);
        int inserted = 0;

        if (length == pos) {
            tail = temp;
        }

        if (pos == 0) {
            temp.next = head;
            head = temp;
            inserted = 1;
            length++;
        } else {
            Node<T> prev = head;

            while (prev != null && pos - 1 != 0) {
                prev = prev.next;
                pos--;
            }

            if (prev != null) {
                temp.next = prev.next;
                prev.next = temp;
                inserted = 1;
                length++;
            }
        }

        return inserted;
    }

    public Node<T> deleteNode(int pos) {
        if (pos > length) {
            return null;
        }
        Node<T> deletedNode = null;
        if (head != null) {
            if (pos == 0) {
                deletedNode = head;
                head = head.next;
                deletedNode.next = null;
                length--;

                if (head == null) {
                    tail = null;
                }
            } else {
                Node<T> prev = head;
                // If last element is deleted then tail needs to be readjusted
                boolean shouldAdjustTail = (pos + 1) == length;
                while (prev != null && pos - 1 != 0) {
                    prev = prev.next;
                    pos--;
                }
                if (prev != null && prev.next != null) {
                    deletedNode = prev.next;
                    prev.next = prev.next.next;
                    deletedNode.next = null;
                    length--;

                    if (shouldAdjustTail) {
                        tail = prev;
                    }
                }
            }
        }

        return deletedNode;
    }

    public T getLast() {
        if (tail == null) {
            return null;
        } else {
            return tail.data;
        }
    }

    public int size() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("LinkedList[");
        Node<T> temp = head;
        while (temp != null) {
            str.append(temp.data).append(",");
            temp = temp.next;
        }
        if (str.toString().endsWith(",")) {
            str.deleteCharAt(str.lastIndexOf(","));
        }
        str.append("]");
        return str.toString();
    }
}

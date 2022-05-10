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

    public boolean isPalindrome() {
        // Finding the mid-point from which it should reverse
        // slow will store the mid-point
        Node<T> slow = head;
        Node<T> fast = head;
        int n = 0;
        while(slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next;
            n++;

            if (fast != null) {
                fast = fast.next;
                n++;
            }
        }
        // Max index upto which it should compare to find palindrome
        n = n / 2 - 1;

        if (slow != null) {
            // Reversing from mid by making a copy
            Node<T> newHead = getReversedCopyOfLinkedList(slow);

            // Find palindrome or not
            slow = head;
            while (slow != null && newHead != null && n >= 0) {
                if (!slow.data.equals(newHead.data)) {
                    return false;
                }
                slow = slow.next;
                newHead = newHead.next;
            }
        }

        return true;
    }

    private Node<T> getReversedCopyOfLinkedList(Node<T> head) {
        Node<T> newHead = copyOfNode(head);
        head = head.next;
        while (head != null) {
            Node<T> temp = copyOfNode(head);
            temp.next = newHead;
            newHead = temp;
            head = head.next;
        }
        return newHead;
    }

    private Node<T> copyOfNode(Node<T> prev) {
        return new Node<>(prev.data);
    }

    @Override
    public String toString() {
        return toString(head);
    }

    private String toString(Node<T> head) {
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

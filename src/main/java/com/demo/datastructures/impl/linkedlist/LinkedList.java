package com.demo.datastructures.impl.linkedlist;

import java.util.Objects;

public class LinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;
    private int length;
    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public static Node<Integer> mergeKLists(Node<Integer>[] lists) {
        if (lists == null) {
            return null;
        } else if (lists.length == 1) {
            return lists[0];
        }
        Node<Integer> currHead = new Node<>(-1);
        Node<Integer> tempNode = currHead;

        while (true) {
            int currVal = Integer.MAX_VALUE;
            int minNodeIdx = -1;
            for (int i = 0; i < lists.length; i++) {
                Node<Integer> curr = lists[i];
                if (curr != null && curr.data.compareTo(currVal) <= 0) {
                    currVal = curr.data;
                    minNodeIdx = i;
                }
            }
            if (minNodeIdx == -1) {
                break;
            } else {
                tempNode.next = lists[minNodeIdx];
                tempNode = tempNode.next;
                lists[minNodeIdx] = lists[minNodeIdx].next;
                tempNode.next = null;
            }
        }

        return currHead.next;
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
        while (slow != null && fast != null) {
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

    public void printRecursively() {
        printRecursively(head);
        System.out.println();
    }

    private void printRecursively(Node<T> head) {
        if (head != null) {
            System.out.print(head.data + " -> ");
            printRecursively(head.next);
        }
    }

    public int insertRecursively(int pos, T data) {
        if (pos == 0) {
            Node<T> node = new Node<>(data);
            node.next = head;
            if (head == null) {
                tail = node;
            }
            head = node;
            length++;
            return 1;
        }
        return insertRecursively(pos, data, head);
    }

    private int insertRecursively(int pos, T data, Node<T> prevNode) {
        if (prevNode == null) {
            return 0;
        } else {
            if (pos - 1 == 0) {
                Node<T> node = new Node<>(data);
                node.next = prevNode.next;
                prevNode.next = node;
                length++;
                return 1;
            }
            return insertRecursively(pos - 1, data, prevNode.next);
        }
    }

    public Node<T> deleteRecursively(int pos) {
        if (head == null) {
            return null;
        } else if (pos == 0) {
            Node<T> deletedNode = head;
            head = head.next;
            deletedNode.next = null;
            length--;
            if (head == null) {
                tail = null;
            }
            return deletedNode;
        } else {
            return deleteRecursively(head, pos);
        }
    }

    private Node<T> deleteRecursively(Node<T> node, int pos) {
        if (node == null && pos > 0) {
            return null;
        } else {
            if (pos - 1 == 0) {
                if (node.next != null) {
                    Node<T> deletedNode = node.next;
                    node.next = node.next.next;
                    if (tail.data.equals(deletedNode.data) && deletedNode.next == null) {
                        tail = node;
                    }
                    deletedNode.next = null;
                    length--;
                    return deletedNode;
                } else {
                    return null;
                }
            }
            return deleteRecursively(node.next, pos - 1);
        }
    }

    public void reverseRecursively() {
        Node<T>[] nodeArr = reverseRecursively(head);
        head = nodeArr[0];
    }

    private Node<T>[] reverseRecursively(Node<T> head) {
        if (head == null || head.next == null) {
            return new Node[]{head, head};
        }
        Node<T>[] result = reverseRecursively(head.next);
        result[1].next = head;
        result[1] = head;
        result[1].next = null;
        return result;
    }

    public void mergeSort() {
        head = mergeSort(head);
    }


    private Node<T> mergeSort(Node<T> head) {
        if (head != null && head.next != null) {
            Node<T> mid = findMidOfLL(head);

            // Break the connection to next
            Node<T> rightHalfHead = mid.next;
            mid.next = null;

            // Recursively call merge in right and left half and merge the result
            head = mergeSort(head);
            rightHalfHead = mergeSort(rightHalfHead);
            head = mergeOfMergeSort(head, rightHalfHead);
        }
        return head;
    }

    private Node<T> mergeOfMergeSort(Node<T> hd1, Node<T> hd2) {
        Node<T> th = null;
        if (hd1.data.compareTo(hd2.data) <= 0) {
            th = hd1;
            hd1 = hd1.next;
        } else {
            th = hd2;
            hd2 = hd2.next;
        }
        Node<T> curr = th;

        while (hd1 != null || hd2 != null) {
            if (hd1 == null) {
                curr.next = hd2;
                break;
            } else if (hd2 == null) {
                curr.next = hd1;
                break;
            } else if (hd1.data.compareTo(hd2.data) <= 0) {
                curr.next = hd1;
                hd1 = hd1.next;
                curr = curr.next;
            } else {
                curr.next = hd2;
                hd2 = hd2.next;
                curr = curr.next;
            }
        }

        return th;
    }

    private Node<T> findMidOfLL(Node<T> head) {
        Node<T> slow = head;
        Node<T> fast = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void kReverse(int k) {
        head = kReverse(head, k);
    }

    private Node<T> kReverse(Node<T> head, int k) {
        if (head == null || head.next == null || k == 0 || k == 1) {
            return head;
        }
        int c = 0;
        Node<T> curr = head;
        Node<T> next = null;
        Node<T> tempHead = head;
        Node<T> prevTail = null;
        while (curr != null) {
            c++;
            if (c == k || curr.next == null) {
                next = curr.next;
                curr.next = null;
                Node<T> temp = tempHead;
                Node<T>[] res = reverse(tempHead, next);
                tempHead = res[0];
                if (temp == head) {
                    head = tempHead;
                } else {
                    prevTail.next = tempHead;
                }
                prevTail = res[1];
                tempHead = next;
                curr = tempHead;
                c = 0;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    private Node<T>[] reverse(Node<T> head, Node<T> next) {
        if (head == null) {
            return null;
        }
        Node<T> tail = head;
        Node<T> th = null;
        while (head != null) {
            Node<T> curr = head;
            head = head.next;
            curr.next = th;
            th = curr;
        }
        tail.next = next;
        return new Node[]{th, tail};
    }

    public static class Node<T extends Comparable<T>> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(data, node.data) && Objects.equals(next, node.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, next);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }

}

package com.practice.programs.revise.linkedlist;

import java.util.Map;
import java.util.HashMap;

class DeepCopyOrLinkedList {

    public Node copyRandomList(Node head) {
        // return deepCopyUsingMap(head);
        return deepCopyOptimized(head);
    }

    /**
     * TC: O (3n), AS: O(1)
     */
    private Node deepCopyOptimized(Node head) {
        Node curr = head;
        // Place temp node after curr Node
        while (curr != null) {
            Node temp = new Node(curr.val, curr.next, null);
            curr.next = temp;
            curr = curr.next.next;
        }
        // Update random pointer
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        // Separate new node from original node
        Node copyHead = new Node(-1, null, null);
        Node tailCopy = copyHead;
        curr = head;
        while (curr != null) {
            tailCopy.next = curr.next;
            tailCopy = tailCopy.next;
            curr.next = tailCopy.next;
            curr = curr.next;
        }
        tailCopy.next = null;
        return copyHead.next;
    }

    /**
     * TC: O(n), AS: O(n)
     */
    private Node deepCopyUsingMap(Node head) {
        Node copyHead = new Node(-1, null, null);
        Node tail = copyHead;
        Map<Node, Node> map = new HashMap<>();
        while (head != null) {
            Node newNode = map.getOrDefault(head, new Node(head.val, null, null));
            if (head.random != null) {
                newNode.random = map.getOrDefault(head.random, new Node(head.random.val, null, null));
                map.putIfAbsent(head.random, newNode.random);
            }
            tail.next = newNode;
            tail = newNode;
            head = head.next;
        }
        return copyHead.next;
    }

    private static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };
}

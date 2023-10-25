package com.practice.programs.easy.doublylinkedlist;

/**
 * TC: O(n), AS: O(1)
 * <a href="https://www.codingninjas.com/studio/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list_8160461?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf">Practice Link</a>
 */
class DeleteAllOccurrencesOfKeyInDLL {

    public static Node deleteAllOccurrences(Node head, int k) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == k) {
                if (curr == head) {
                    curr = curr.next;
                    if (curr != null) {
                        curr.prev = null;
                    }
                    head = curr;
                } else {
                    curr.prev.next = curr.next;
                    if (curr.next != null) {
                        curr.next.prev = curr.prev;
                    }
                    curr = curr.next;
                }
            } else {
                curr = curr.next;
            }
        }
        return head;
    }


    private static class Node {
        public int data;
        public Node next;
        public Node prev;
    }
}

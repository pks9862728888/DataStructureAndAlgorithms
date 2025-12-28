package com.practice.programs.revise.medium.linkedlist;

import com.practice.programs.revise.medium.utils.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/description/
 * TC: O(n), AS: O(1)
 * Concepts:
 * LINKED_LIST
 * FAST_AND_SLOW_POINTER
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        return hasCycle;
    }

  public static int countCycleLength(ListNode head) {
    if (head == null || head.next == null) return 0;

    ListNode slow = head;
    ListNode fast = head;

    // find intersection point
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }

    // if cycle exists find length of cycle
    int cycleLength = 0;
    if (fast != null && slow == fast) {
      slow = fast;
      while (true) {
        slow = slow.next;
        cycleLength++;
        if (slow == fast) break;
      }
    }
    return cycleLength;
  }
}

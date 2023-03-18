package idv.paul.leetcode.linkedlist;

import idv.paul.leetcode.util.ListNode;

import static idv.paul.leetcode.util.ListNode.constructLinkedListNode;

/*
https://leetcode.com/problems/linked-list-cycle/
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.
 */
public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;

    }
    public static void main(String... argv) {
        ListNode head = constructLinkedListNode(new int[]{3, 2, 0, 4});
        ListNode second = head.next;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = second;
        System.out.println("has cycle? " + hasCycle(head));
    }
}

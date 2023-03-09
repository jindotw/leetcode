package idv.paul.leetcode.linkedlist;

import idv.paul.leetcode.util.ListNode;

import static idv.paul.leetcode.util.ListNode.printListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/">Reverse Linked List</a>
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode tmp;

        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        return prev;
    }

    public static void main(String ...argv) {
        ListNode listNode = ListNode.constructLinkedListNode(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
        ListNode reversed = reverseList(listNode);
        printListNode(reversed);

    }
}

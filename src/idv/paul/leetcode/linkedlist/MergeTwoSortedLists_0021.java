package idv.paul.leetcode.linkedlist;

/*
Easy
https://leetcode.com/problems/merge-two-sorted-lists/?envType=study-plan&id=level-1

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]
 */

import idv.paul.leetcode.util.ListNode;

public class MergeTwoSortedLists_0021 {

    public static ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                list1.next = mergeTwoLists3(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists3(list1, list2.next);
                return list2;
            }
        }

        return list1 != null ? list1 : list2;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0, null);
        ListNode start = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                start.next = list1;
                list1 = list1.next;
            } else {
                start.next = list2;
                list2 = list2.next;
            }
            start = start.next;
        }

        while (list1 != null) {
            start.next = list1;
            list1 = list1.next;
            start = start.next;
        }

        while (list2 != null) {
            start.next = list2;
            list2 = list2.next;
            start = start.next;
        }

        return dummy.next;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // dummy node
        ListNode list = new ListNode(-1);
        ListNode ptr = list;

        while (list1 != null && list2 != null) {
            int val;
            if (list1.val <= list2.val) {
                val = list1.val;
                list1 = list1.next;
            } else {
                val = list2.val;
                list2 = list2.next;
            }
            ptr.next = new ListNode(val);
            ptr = ptr.next;

        }
        while (list1 != null) {
            ptr.next = new ListNode(list1.val);
            list1 = list1.next;
            ptr = ptr.next;
        }
        while (list2 != null) {
            ptr.next = new ListNode(list2.val);
            list2 = list2.next;
            ptr = ptr.next;
        }

        return list.next;
    }

    public static void main(String... argv) {
        ListNode l1 = ListNode.constructLinkedListNode(new int[]{1,7,9});
        ListNode l2 = ListNode.constructLinkedListNode(new int[]{1,4,8, 20});
        ListNode l3 = mergeTwoLists3(l1, l2);
        ListNode.printListNode(l3);
    }
}

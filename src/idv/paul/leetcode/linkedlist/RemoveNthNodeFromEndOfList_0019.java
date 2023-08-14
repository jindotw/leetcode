package idv.paul.leetcode.linkedlist;

/*
19. Remove Nth Node From End of List
Medium
16.7K
694
Companies
Given the head of a linked list, remove the nth node from the end of the list and return its head.



Example 1:


Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]


Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz


Follow up: Could you do this in one pass?

Related Topics
Linked List
Two Pointers

 */

import idv.paul.leetcode.util.ListNode;

import static idv.paul.leetcode.util.ListNode.printListNode;


public class RemoveNthNodeFromEndOfList_0019 {
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(0, head);
		ListNode slow = dummy, fast = head;

		for (int i=0; fast != null && i<n; i++) {
			fast = fast.next;
		}

		if (fast == null) {
			return head.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		if (slow.next != null) {
			slow.next = slow.next.next;
		}

		return dummy.next;
	}

	public static void main(String ...argv) {
		ListNode n5 = new ListNode(5);
		ListNode n4 = new ListNode(4, n5);
		ListNode n3 = new ListNode(3, n4);
		ListNode n2 = new ListNode(2, n3);
		ListNode n1 = new ListNode(1, n2);

		printListNode(removeNthFromEnd(n1, 2));
	}
}

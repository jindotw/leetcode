package idv.paul.leetcode.linkedlist;

/*
234. Palindrome Linked List
Easy
14.9K
810
Companies
Given the head of a singly linked list, return true if it is a
palindrome
 or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true
Example 2:

Input: head = [1,2]
Output: false


Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9


Follow up: Could you do it in O(n) time and O(1) space?

Related Topics
Linked List
Two Pointers
Stack
Recursion
 */

import idv.paul.leetcode.util.ListNode;

import java.util.Stack;

public class PalindromeLinkedList_0234 {
	public static boolean isPalindrome(ListNode head) {
		Stack<Integer> st = new Stack<>();
		ListNode dummy = head;

		while (dummy != null) {
			st.push(dummy.val);
			dummy = dummy.next;
		}

		dummy = head;
		while (dummy != null) {
			if (st.pop() != dummy.val) {
				return false;
			}
			dummy = dummy.next;
		}

		return true;
	}

	public static void main(String ...argv) {
		ListNode n4 = new ListNode(1);
		ListNode n3 = new ListNode(2, n4);
		ListNode n2 = new ListNode(2, n3);
		ListNode n1 = new ListNode(1, n2);
		System.out.println(isPalindrome(n1));
	}
}

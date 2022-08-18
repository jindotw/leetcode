package idv.paul.leetcode;

import idv.paul.leetcode.util.ListNode;

import static idv.paul.leetcode.util.ListNode.constructLinkedListNode;
import static idv.paul.leetcode.util.ListNode.printListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode pointer = new ListNode(0);
        // this node serves as the entry node
        ListNode root = pointer;

        while (l1 != null || l2 != null) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            pointer.next = new ListNode(sum % 10);
            // points to the newly created node
            pointer = pointer.next;
        }
        if (carry > 0) {
            pointer.next = new ListNode(carry);
        }

        return root.next;
    }

    public static void ans(int[] nums1, int [] nums2) {
        ListNode l1 = constructLinkedListNode(nums1);
        ListNode l2 = constructLinkedListNode(nums2);
        ListNode l3 = addTwoNumbers(l1, l2);
        printListNode(l1);
        printListNode(l2);
        printListNode(l3);
    }

    public static void main(String... args) {
        ans(new int[] {2, 4, 3}, new int[] {5, 6, 4});
        System.out.println();
        ans(new int[] {0}, new int[] {0});
        System.out.println();
        ans(new int[] {9, 9, 9, 9, 9, 9, 9}, new int[] {9, 9, 9, 9});
    }
}

package idv.paul.leetcode.recursion;

import idv.paul.leetcode.util.ListNode;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        return list1 == null ? list2 : list1;
    }

    public static void main(String... argv) {
        ListNode l1 = ListNode.constructLinkedListNode(new int[]{1,3});
        ListNode l2 = ListNode.constructLinkedListNode(new int[]{2});
        ListNode l3 = mergeTwoLists(l1, l2);
        ListNode.printListNode(l3);
    }
}

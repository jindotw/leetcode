package idv.paul.leetcode.util;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode constructLinkedListNode(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        ListNode listNode = null;
        ListNode nextNode = null;
        for (int i=nums.length-1; i >= 0; --i) {
            int num = nums[i];
            listNode = new ListNode(num, nextNode);
            nextNode = listNode;
        }

        return listNode;
    }

    public static void printListNode(ListNode listNode) {
        if (listNode == null)
            return;

        System.out.print("[");
        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
            if (listNode != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

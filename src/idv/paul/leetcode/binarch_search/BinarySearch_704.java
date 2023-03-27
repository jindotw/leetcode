package idv.paul.leetcode.binarch_search;

/*
Easy
https://leetcode.com/problems/binary-search/

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1
 */
public class BinarySearch_704 {
    public static int search(int[] nums, int target) {
        int lft = 0, rgt = nums.length-1;
        while (lft <= rgt) {
            int mid = (lft + rgt) / 2;
            int num = nums[mid];
            if (num == target) {
                return mid;
            }
            if (num > target) {
                rgt = mid - 1;
            } else {
                lft = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String... argv) {
        int pos = search(new int[]{-1, 0, 3, 5, 9, 12}, 13);
        System.out.println("pos=" + pos);
    }
}

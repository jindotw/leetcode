package idv.paul.leetcode.binarch_search;

/*
Easy
https://leetcode.com/problems/search-insert-position
Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 */
public class SearchInsertionPosition_35 {
    public static int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;

        while (lo <= hi) {
            int mid = (lo+hi)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public static void main(String... argv) {
        int pos = searchInsert(new int[]{1,3,5,6}, 0);
        System.out.println("position=" + pos);
    }
}

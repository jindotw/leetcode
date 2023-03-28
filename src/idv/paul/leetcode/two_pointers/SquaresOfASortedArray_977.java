package idv.paul.leetcode.two_pointers;
/*
Easy
https://leetcode.com/problems/squares-of-a-sorted-array/
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
 */

import java.util.Arrays;

public class SquaresOfASortedArray_977 {
    public static int[] sortedSquares(int[] nums) {
        int[] squared = new int[nums.length];
        int lft=0, rgt=nums.length-1;
        int pos = nums.length-1;

        while (lft <= rgt) {
            if (Math.abs(nums[lft]) > Math.abs(nums[rgt])) {
                squared[pos] = nums[lft] * nums[lft];
                lft++;
            } else {
                squared[pos] = nums[rgt] * nums[rgt];
                rgt--;
            }
            pos--;
        }

        return squared;
    }

    public static void main(String... argv) {
        int[] ans = sortedSquares(new int[]{-4, -1, 0, 3, 10});
        System.out.println(Arrays.toString(ans));
    }
}

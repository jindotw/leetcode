package idv.paul.leetcode.two_pointers;
/*
https://leetcode.com/problems/rotate-array/?envType=study-plan&id=algorithm-i

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
 */

import java.util.Arrays;

public class RotateArray_189 {

    public static void reverse(int[] arr, int start, int end) {
        while (end > start) {
            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
            start++;
            end--;
        }
    }
    public static void rotate(int[] nums, int k) {
        int steps = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, steps-1);
        reverse(nums, steps, nums.length-1);

    }

    public static void main(String... argv) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}

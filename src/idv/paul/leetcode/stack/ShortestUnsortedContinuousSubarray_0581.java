package idv.paul.leetcode.stack;

/*
581. Shortest Unsorted Continuous Subarray
Medium

Given an integer array nums, you need to find one continuous subarray such that if you only sort this subarray in non-decreasing order, then the whole array will be sorted in non-decreasing order.

Return the shortest such subarray and output its length.

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ShortestUnsortedContinuousSubarray_0581 {
	public int findUnsortedSubarray(int[] nums) {
		Deque<Integer> st = new ArrayDeque<>();
		int lftBound = nums.length - 1;
		int rgtBound = 0;

		for (int i=0; i<nums.length; i++) {
			while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
				int pos = st.pop();
				lftBound = Math.min(lftBound, pos);
			}
			st.push(i);
		}
		st.clear();
		for (int i=nums.length-1; i>=0; i--) {
			while (!st.isEmpty() && nums[i] > nums[st.peek()]) {
				int pos = st.pop();
				rgtBound = Math.max(rgtBound, pos);
			}
			st.push(i);
		}
		return rgtBound> lftBound ? rgtBound-lftBound+1 : 0;
	}

	public static void main(String ...argv) {
		// int[] nums = new int[]{2,6,4,8,10,9,15};
		int[] nums = new int[]{1};
		int shortest = new ShortestUnsortedContinuousSubarray_0581().findUnsortedSubarray(nums);
		System.out.println(shortest);
	}
}

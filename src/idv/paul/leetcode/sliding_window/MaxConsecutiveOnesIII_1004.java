package idv.paul.leetcode.sliding_window;

/*
https://leetcode.com/problems/max-consecutive-ones-iii/description/

1004. Max Consecutive Ones III
Medium

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.

Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */

public class MaxConsecutiveOnesIII_1004 {
	public static int longestOnes(int[] nums, int k) {
		int lft = 0;

		for (int num : nums) {
			k -= num ^ 1;

			if (k < 0) {
				k += nums[lft] ^ 1;
				lft++;
			}
		}
		return nums.length - lft;
	}

	public static void main(String ...argv) {
		int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
		int k = 2;

		System.out.println(longestOnes(nums, k));
	}
}

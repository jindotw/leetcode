package idv.paul.leetcode.array;

/*
https://leetcode.com/problems/4sum-ii/

454. 4Sum II
Medium
4.7K
131
Companies
Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0


Example 1:

Input: nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
Output: 2
Explanation:
The two tuples are:
1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
Example 2:

Input: nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
Output: 1


Constraints:

n == nums1.length
n == nums2.length
n == nums3.length
n == nums4.length
1 <= n <= 200
-228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228

Related Topics
Array
Hash Table
 */

import java.util.HashMap;
import java.util.Map;

public class FourSumII_0454 {
	public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		Map<Integer, Integer> cache = new HashMap<>();

		for (int num1 : nums1) {
			for (int num2 : nums2) {
				int sum = num1 + num2;
				cache.put(sum, cache.getOrDefault(sum, 0) + 1);
			}
		}

		int count = 0;
		for (int num3 : nums3) {
			for (int num4 : nums4) {
				int sum = -(num3 + num4);
				if (cache.containsKey(sum)) {
					count += cache.get(sum);
				}
			}
		}

		return count;
	}

	public static void main(String ...argv) {
		int[] nums1 = new int[]{1, 2};
		int[] nums2 = new int[]{-2, -1};
		int[] nums3 = new int[]{-1, 2};
		int[] nums4 = new int[]{0, 2};

		System.out.println(fourSumCount(nums1, nums2, nums3, nums4));
	}
}

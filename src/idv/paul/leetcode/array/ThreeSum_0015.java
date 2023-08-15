package idv.paul.leetcode.array;

/*
https://leetcode.com/problems/3sum/
15. 3Sum
Medium
27.7K
2.5K
Companies
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105

Related Topics
Array
Two Pointers
Sorting
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_0015 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		for (int i=0; i<nums.length; i++) {
			if (nums[i] > 0)
				break;
			if (i > 0 && nums[i] == nums[i-1])
				continue;

			int lft = i+1, rgt = nums.length-1;
			while (lft < rgt) {
				int sum = nums[i] + nums[lft] + nums[rgt];
				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[lft], nums[rgt]));
					while (lft < rgt && nums[rgt] == nums[rgt-1]) rgt--;
					while (lft < rgt && nums[lft] == nums[lft+1]) lft++;
					lft++;
					rgt--;
				} else if (sum > 0) {
					rgt--;
				} else {
					lft++;
				}
			}
		}

		return result;
	}

	public static void main(String ...argv) {
		// [-4, -1, -1, 0, 1, 2]
		int[] nums = new int[]{-1,0,1,2,2, -1, -1,-4};
		List<List<Integer>> result = threeSum(nums);
		for (List<Integer> row : result) {
			for (Integer num : row) {
				System.out.printf("%d ", num);
			}
			System.out.println();
		}
	}
}

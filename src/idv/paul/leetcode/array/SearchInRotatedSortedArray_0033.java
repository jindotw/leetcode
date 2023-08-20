package idv.paul.leetcode.array;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/

33. Search in Rotated Sorted Array
Medium
23.8K
1.4K
Companies
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */

public class SearchInRotatedSortedArray_0033 {
	public static int search(int[] nums, int target) {
		int pivot = nums[0];
		int lft = 0, rgt = nums.length-1;
		while (lft <= rgt) {
			int mid = lft + ((rgt-lft) >> 1);
			if (nums[mid] == target) {
				return mid;
			} else {
				if (pivot > target) {
					if (nums[mid] >= pivot) {
						lft = mid + 1;
					} else {
						if (nums[mid] > target) {
							rgt = mid - 1;
						} else {
							lft = mid + 1;
						}
					}
				} else {
					if (nums[mid] < pivot) {
						rgt = mid - 1;
					} else {
						if (nums[mid] < target) {
							lft = mid + 1;
						} else {
							rgt = mid - 1;
						}
					}
				}
			}
		}

		return -1;

	}

	public static int search2(int[] nums, int target) {
		int lft = 0, rgt = nums.length - 1;

		while (lft <= rgt) {
			int mid = lft + ((rgt-lft) >> 1);

			if (nums[mid] == target)
				return mid;

			if (nums[lft] < nums[mid]) {
				if (target >= nums[lft] && target < nums[mid])
					rgt = mid -1;
				else
					lft = mid + 1;
			} else {
				if (target >= nums[lft] && target > nums[mid])
					rgt = mid - 1;
				else
					lft = mid + 1;
			}
		}

		return -1;
	}

	public static void main(String ...argv) {
		// int[] nums = new int[]{1, 3};
		// 7, 0, 1, 2, 4, 5, 6
		int[] nums = new int[]{4, 5, 6, 0, 1, 2, 3};
		int target = 0;
		System.out.println(search(nums, target));
		System.out.println(search2(nums, target));
	}
}

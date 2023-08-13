package idv.paul.leetcode.array;

/*
https://leetcode.com/problems/contains-duplicate/

217. Contains Duplicate
Easy

Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109

Related Topics
Array
Hash Table
Sorting
 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate_0217 {
	public static boolean containsDuplicate(int[] nums) {
		Set<Integer> cache = new HashSet<>();
		for (int num : nums) {
			if (cache.contains(num)) {
				return true;
			}
			cache.add(num);
		}

		return false;
	}

	public static void main(String ...argv) {
		int[] nums = new int[]{1, 2, 3, 4};
		System.out.println(containsDuplicate(nums));
	}
}

package idv.paul.leetcode.array;
/*
https://leetcode.com/problems/intersection-of-two-arrays-ii/

350. Intersection of Two Arrays II
Easy

Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArraysII_0350 {
	public static int[] intersect(int[] nums1, int[] nums2) {
		List<Integer> arr = new ArrayList<>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i=0, j=0;

		while (i<nums1.length && j<nums2.length) {
			if (nums1[i] == nums2[j]) {
				arr.add(nums1[i]);
				i++;
				j++;
			} else if (nums1[i] < nums2[j]) {
				i++;
			} else {
				j++;
			}
		}

		int[] result = new int[arr.size()];
		for (i=0; i<arr.size(); i++) {
			result[i] = arr.get(i);
		}
		return result;
	}

	public static void main(String ...argv) {
		int[] nums1 = new int[]{4, 9 , 5};
		int[] nums2 = new int[]{4, 9};
		// 1 1 2 2
		// 2 2
		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}
}

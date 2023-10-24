package idv.paul.leetcode.two_pointers;

/*
42. Trapping Rain Water
Hard

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
*/

public class TrappingRainWater_0042 {
	public int trap(int[] height) {
		int lft = 0, rgt = height.length-1;
		int maxL = height[lft], maxR = height[rgt];
		int trapped = 0;

		while (lft < rgt) {
			if (maxL <= maxR) {
				lft++;
				maxL = Math.max(maxL, height[lft]);
				trapped += maxL - height[lft];
			} else {
				rgt--;
				maxR = Math.max(maxR, height[rgt]);
				trapped += maxR - height[rgt];
			}
		}

		return trapped;
	}

	public static void main(String ...argv) {
		int[] height = new int[]{1,0,0,2,1,0,1,3,2,1,2,2};
		int trapped = new TrappingRainWater_0042().trap(height);
		System.out.println(trapped);
	}
}

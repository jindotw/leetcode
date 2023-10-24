package idv.paul.leetcode.stack;

/*
84. Largest Rectangle in Histogram
Hard

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

Example 1:

Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:

Input: heights = [2,4]
Output: 4


Constraints:

1 <= heights.length <= 105
0 <= heights[i] <= 104
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram_0084 {
	public int largestRectangleArea(int[] heights) {
		int maxArea = 0;
		Deque<Pair> st = new ArrayDeque<>();
		for (int i=0; i<heights.length; ++i) {
			int height = heights[i];
			int start = i;
			while (!st.isEmpty() && st.peek().height > height) {
				Pair p = st.pop();
				// i - p.idx = width of the bar being popped
				maxArea = Math.max(maxArea, (i - p.idx) * p.height);
				start = p.idx;
			}
			st.push(new Pair(start, height));
		}
		while (!st.isEmpty()) {
			Pair p = st.pop();
			maxArea = Math.max(maxArea, (heights.length-p.idx) * p.height);
		}

		return maxArea;
	}

	public static void main(String ...argv) {
		int[] heights = new int[]{2,1,5,6,2,3};
		int area = new LargestRectangleInHistogram_0084().largestRectangleArea(heights);
		System.out.println(area);
	}

	private static class Pair {
		int idx;
		int height;

		Pair(int idx, int height) {
			this.idx = idx;
			this.height = height;
		}
	}
}

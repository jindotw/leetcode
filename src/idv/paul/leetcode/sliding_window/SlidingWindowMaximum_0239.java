package idv.paul.leetcode.sliding_window;

/*
https://leetcode.com/problems/sliding-window-maximum/description/

239. Sliding Window Maximum
Hard

You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation:
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
 */

import java.util.*;

public class SlidingWindowMaximum_0239 {
	public static int[] maxSlidingWindow(int[] nums, int k) {
		List<Integer> result = new ArrayList<>(nums.length-k+1);
		Deque<Integer> queue = new ArrayDeque<>();
		for (int lft =0, rgt = 0; rgt < nums.length; rgt++) {
			int num = nums[rgt];
			while (!queue.isEmpty() && num > queue.peekLast()) {
				queue.removeLast();
			}
			queue.offer(num);

			if (rgt+ 1 >= k) {
				result.add(queue.peekFirst());
				if (!queue.isEmpty() && queue.peekFirst() == nums[lft]) {
					queue.removeFirst();
				}
				lft++;
			}
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	public static void main(String ...argv) {
		int[] nums = new int[]{1,3,1,2,0,5};
		int k = 3;
		System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
	}
}

// 1 3 1 -> 3
// 3 1 2 -> 3
// 1 2 0 -> 2
// 2 0 5 -> 5
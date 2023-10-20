package idv.paul.leetcode.stack;

/*
739. Daily Temperatures
Medium

Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]


Constraints:

1 <= temperatures.length <= 105
30 <= temperatures[i] <= 100
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures_0739 {
	public static int[] dailyTemperatures(int[] temperatures) {
		Deque<Integer> st = new ArrayDeque<>();
		int[] result = new int[temperatures.length];
		for (int i=0; i<temperatures.length; ++i) {
			while (!st.isEmpty() && temperatures[i] > temperatures[st.peek()]) {
				int prev = st.pop();
				result[prev] = i - prev;
			}
			st.push(i);
		}

		return result;
	}

	public static void main(String ...argv) {
		int[] temperatures = new int[]{73,74,75,71,69,72,76,73};
		System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
	}
}

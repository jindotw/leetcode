package idv.paul.leetcode.array;

/*
https://leetcode.com/problems/plus-one/
66. Plus One
Easy
7.9K
5.1K
Companies
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.



Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].


Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.

Related Topics
Array
Math
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne_0066 {

	public static int[] plusOne2(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}

		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}

	public static int[] plusOne(int[] digits) {
		List<Integer> result = new ArrayList<>();
		int carry = 1;
		for (int i=digits.length-1; i>=0; i--) {
			int num = digits[i];
			if (carry == 1) {
				num++;
			}
			if (num > 9) {
				result.add(0);
				carry = 1;
			} else {
				result.add(num);
				carry = 0;
			}
		}
		if (carry == 1) {
			result.add(1);
		}
		int[] ans = new int[result.size()];
		for (int i=0; i<result.size(); i++) {
			ans[ans.length-i-1] = result.get(i);
		}
		return ans;
	}

	public static void main(String ...argv) {
		int[] nums = new int[]{1, 9};
		System.out.println(Arrays.toString(plusOne2(nums)));
	}
}

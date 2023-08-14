package idv.paul.leetcode.string;

/*
7. Reverse Integer
Medium

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321
Example 2:

Input: x = -123
Output: -321
Example 3:

Input: x = 120
Output: 21

Constraints:
-231 <= x <= 231 - 1

Related Topics
Math
 */

public class ReverseInteger_0007 {
	public static int reverse(int x) {
		StringBuilder sb = new StringBuilder();
		if (x < 0) {
			x = x * -1;
			sb.append("-");
		}

		while (x > 0) {
			sb.append(x % 10);
			x /= 10;
		}

		try {
			return Integer.parseInt(sb.toString());
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static void main(String ...argv) {
		System.out.println(reverse(1));
	}
}

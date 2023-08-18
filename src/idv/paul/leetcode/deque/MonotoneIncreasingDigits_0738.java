package idv.paul.leetcode.deque;

/*
https://leetcode.com/problems/monotone-increasing-digits/

738. Monotone Increasing Digits
Medium
1.2K
98
Companies
An integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.

Given an integer n, return the largest number that is less than or equal to n with monotone increasing digits.


Example 1:

Input: n = 10
Output: 9
Example 2:

Input: n = 1234
Output: 1234
Example 3:

Input: n = 332
Output: 299


Constraints:

0 <= n <= 109

Related Topics
Math
Greedy
 */

import java.util.function.Supplier;

public class MonotoneIncreasingDigits_0738 {
	public static int monotoneIncreasingDigits(int n) {
		if (n < 10)
			return n;
		final int length = (int)Math.log10(n) + 1;
		int[] digits = new int[length];
		for (int i=0; i<length; i++) {
			digits[length-1-i] = n % 10;
			n /= 10;
		}

		Supplier<Boolean> matched = () -> {
			for (int i=1; i<length; i++) {
				if (digits[i] < digits[i - 1])
					return false;
			}
			return true;
		};

		while (!matched.get()) {
			for (int i = 1; i < length; i++) {
				if (digits[i - 1] > digits[i]) {
					digits[i - 1]--;
					for (int j = i; j < digits.length; j++)
						digits[j] = 9;
				}
			}
		}

		int result = 0;
		for (int digit : digits) {
			result = result * 10 + digit;
		}

		return result;
	}

	public static int monotoneIncreasingDigits2(int n) {
		int position;
		int digitInTheNextPosition;
		while ((position = getViolatingPosition(n)) != -1) {
			digitInTheNextPosition = ((int) (n / Math.pow(10, position - 1))) % 10;
			double diff = Math.pow(10, position - 1) * (digitInTheNextPosition + 1);
			n -= diff;
			n -= n % Math.pow(10, position);
			n += Math.pow(10, position) - 1;
		}
		return n;
	}

	// 1234
	public static int getViolatingPosition(int n) {
		int k = 10;
		int position = 0;
		while (n > 0) {
			int digit = n % 10;
			if (k < digit) {
				return position;
			} else {
				k = digit;
				n /= 10;
				position++;
			}
		}
		return -1;
	}



	public static void main(String ...argv) {
		int n = 2854;
		System.out.println(monotoneIncreasingDigits(n));
		System.out.println(monotoneIncreasingDigits2(n));
	}
}

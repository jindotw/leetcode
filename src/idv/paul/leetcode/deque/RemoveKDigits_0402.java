package idv.paul.leetcode.deque;

/*
https://leetcode.com/problems/remove-k-digits/

402. Remove K Digits
Medium
8K
342
Companies
Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.



Example 1:

Input: num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
Example 2:

Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.


Constraints:

1 <= k <= num.length <= 105
num consists of only digits.
num does not have any leading zeros except for the zero itself.

Related Topics
String
Stack
Greedy
Monotonic Stack
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits_0402 {

	public static String removeKdigits2(String num, int k) {
		if (num.length() == k) {
			return "0";
		}
		StringBuilder sb = new StringBuilder();
		for (char digit : num.toCharArray()) {
			int len = sb.length();
			while (k > 0 && len > 0 && digit < sb.charAt(len-1)) {
				sb.deleteCharAt(len-1);
				k--;
				len--;
			}
			sb.append(digit);
		}
		while (!sb.isEmpty() && k > 0) {
			sb.deleteCharAt(sb.length()-1);
			k--;
		}
		while (!sb.isEmpty() && sb.charAt(0) == '0') {
			sb.deleteCharAt(0);
		}

		return !sb.isEmpty() ? sb.toString() : "0";
	}
	public static String removeKdigits(String num, int k) {
		Deque<Character> st = new ArrayDeque<>();
		for (int i=0; i<num.length(); i++) {
			char ch = num.charAt(i);
			while (k > 0 && !st.isEmpty() && ch < st.peek()) {
				st.pop();
				k--;
			}
			st.push(ch);
		}
		while (!st.isEmpty() && k > 0) {
			st.pop();
			k--;
		}

		StringBuilder sb = new StringBuilder();
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		sb.reverse();
		while (sb.length() > 0 && sb.charAt(0) == '0') {
			sb.delete(0, 1);
		}
		if (sb.length() == 0) {
			return "0";
		}

		return sb.toString();

	}
	public static void main(String ...argv) {
		String num = "112";
		int k = 1;
		System.out.println(removeKdigits2(num, k));
	}
}

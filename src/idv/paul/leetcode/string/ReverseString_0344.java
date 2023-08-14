package idv.paul.leetcode.string;

/*
https://leetcode.com/problems/reverse-string/
344. Reverse String
Easy
7.7K
1.1K
Companies
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.



Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]


Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.

Related Topics
Two Pointers
String
 */

import java.util.Arrays;

public class ReverseString_0344 {

	public static void reverseString(char[] s) {
		for (int i=0; i<s.length/2; i++) {
			int last = s.length-i-1;
			char tmp = s[i];
			s[i] = s[last];
			s[last] = tmp;
		}
	}

	public static void main(String ...argv) {
		char[] s = new char[]{'h','e','l','l','o'};
		reverseString(s);
		System.out.println(Arrays.toString(s));
	}
}

package idv.paul.leetcode.string;
/*
https://leetcode.com/problems/valid-palindrome/

125. Valid Palindrome
Easy
7.7K
7.6K
Companies
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

Related Topics
Two Pointers
String
 */

public class ValidPalindrome_0125 {
	public static boolean isPalindrome(String s) {
		char[] chars = new char[s.length()];
		int pos = 0;
		for (int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
				chars[pos++] = Character.toLowerCase(ch);
			}
		}
		int lft = 0, rgt = pos-1;
		while (lft < rgt) {
			if (chars[lft++] != chars[rgt--])
					return false;
		}
		return true;
	}

	public static void main(String ...argv) {
		// System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(isPalindrome("AbBa"));
	}
}

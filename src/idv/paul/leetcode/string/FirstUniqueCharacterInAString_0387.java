package idv.paul.leetcode.string;

/*
387. First Unique Character in a String
Easy
8.1K
260
Companies
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.



Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1


Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters.

Related Topics
Hash Table
String
Queue
Counting
 */

public class FirstUniqueCharacterInAString_0387 {
	public static int firstUniqChar(String s) {
		int[] counter = new int[128];

		for (int i=0; i<s.length(); i++) {
			counter[s.charAt(i)]++;
		}

		for (int i=0; i<s.length(); i++) {
			if (counter[s.charAt(i)] == 1)
				return i;
		}

		return -1;
	}

	public static void main(String ...argv) {
		System.out.println(firstUniqChar("aabb"));
	}
}

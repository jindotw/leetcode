package idv.paul.leetcode.string;

/*
14. Longest Common Prefix
Easy
15.2K
4.1K
Companies
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.

Related Topics
String
Trie
 */

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix_0014 {

	public static String binarySearch(String[] strs) {
		if (strs.length == 1) {
			return strs[0];
		}

		int minLen = Integer.MAX_VALUE;
		for (String str : strs) {
			minLen = Math.min(str.length(), minLen);
		}

		int low = 0, high = minLen;
		while (low <= high) {
			int mid = low + ((high - low) >> 1);
			if (isCommon(strs, mid)) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}

		}

		return strs[0].substring(0, low + ((high - low) >> 1));
	}

	public static boolean isCommon(String[] strs, int len) {
		String s = strs[0].substring(0, len);

		for (String str : strs) {
			if (!str.startsWith(s)) {
				return false;
			}
		}

		return true;
	}
	public static String longestCommonPrefix(String[] strs) {
		Arrays.sort(strs, (s1, s2) -> {
			if (s1.length() < s2.length()) {
				return -1;
			} else if (s1.length() > s2.length()) {
				return 1;
			}
			return 0;
		});
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<strs[0].length(); i++) {
			int count = 0;
			char curr = strs[0].charAt(i);
			for (int j=1; j < strs.length; j++) {
				if (strs[j].charAt(i) == curr) {
					count++;
				}
			}
			if (count == strs.length-1) {
				sb.append(curr);
			} else {
				break;
			}
		}

		return sb.toString();
	}

	public static void main(String ...argv) {
		String[] strs = new String[]{ "flower", "flow", "flight" };
		System.out.println(binarySearch(strs));
	}
}

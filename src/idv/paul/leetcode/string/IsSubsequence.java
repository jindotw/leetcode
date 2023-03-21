package idv.paul.leetcode.string;

/*
Easy
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).

Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false
 */
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (s.length()==0) {
            return true;
        }
        int pos = 0;
        int curChr = s.charAt(pos);
        for (int i=0, len=t.length(); i<len; ++i) {
            if (t.charAt(i) == curChr) {
                if (++pos == s.length()) {
                    return true;
                }
                curChr = s.charAt(pos);
            }
        }

        return false;
    }

    public static void main(String... argv) {
        String s = "aec";
        String t = "abcde";
        boolean isSub = isSubsequence(s, t);
        System.out.printf("s=%s, t=%s, isSubsequence=%s", s, t, isSub ? "true" : "false");
    }
}

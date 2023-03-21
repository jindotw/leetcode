package idv.paul.leetcode.string;

/*
Easy
https://leetcode.com/problems/isomorphic-strings/?envType=study-plan&id=level-1
Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
 */
public class Isomorphic {
    public static boolean isIsomorphic(String s, String t) {
        int[] dict1 = new int[200];
        int[] dict2 = new int[200];
        for (int i=0, len = s.length(); i<len; ++i) {
            int pos1 = s.charAt(i);
            int pos2 = t.charAt(i);
            if (dict1[pos1] != dict2[pos2]) {
                return false;
            }

            // i+1 to ensure default value of 0 in the dictionaries is not confused with an actual position
            dict1[pos1] = i + 1;
            dict2[pos2] = i + 1;
        }

        return true;
    }

    public static void main(String... argv) {
        String s = "egg";
        String t = "add";
        boolean isomorphic = isIsomorphic(s, t);
        System.out.printf("'%s' and '%s', isomorphic=%s", s, t, isomorphic ? "true" : "false");

    }
}

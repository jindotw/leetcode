package idv.paul.leetcode.leetcode75.easy;
/*
1071. Greatest Common Divisor of Strings [Easy]

For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).
Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Example 1:
Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"

Example 2:
Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"

Example 3:
Input: str1 = "LEET", str2 = "CODE"
Output: ""

Constraints:
1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
*/

public class GreatestCommonDivisorOfStrings_1071 {
    /*
     * algorithm is okay but can be further optimized
     */
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length(), len2 = str2.length();
        int gcd = Math.min(len1, len2);

        while (gcd > 0) {
            if ((len1 % gcd == 0) && (len2 % gcd == 0))
                break;
            --gcd;
        }
        if (gcd == 0)
            return "";

        String result = str2.substring(0, gcd);

        return notDivisible(str1, result) || notDivisible(str2, result) ? "" : result;
    }

    private boolean notDivisible(String mainStr, String refStr) {
        for (int i=0, idx = 0; i<mainStr.length(); ++i) {
            if (mainStr.charAt(i) != refStr.charAt(idx))
                return true;
            if (++idx >= refStr.length())
                idx = 0;
        }

        return false;
    }

    public static void main(String... argv) {
        final String s1 = "ABABAB";
        final String s2 = "ABAB";
        String ret = new GreatestCommonDivisorOfStrings_1071().gcdOfStrings(s1, s2);
        System.out.println("The GCD of " + s1 + " and " + s2 + " = " + ret);
    }
}

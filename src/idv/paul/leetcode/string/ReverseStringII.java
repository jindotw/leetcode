package idv.paul.leetcode.string;

/**
 * <a href="https://leetcode.com/problems/reverse-string-ii/">Reverse String II</a>
 *
 * Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
 *
 * If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
 *
 * Example 1:
 *
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 * Input: s = "abcd", k = 2
 * Output: "bacd"
 */
public class ReverseStringII {
    public static String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();

        for (int i=0, end; i<ch.length; i += 2*k) {
            end = i + k;
            // end = Math.min(end, ch.length);
            int lft = i, rgt = Math.min(end-1, ch.length-1);
            while (lft < rgt) {
                char tmp = ch[lft];
                ch[lft] = ch[rgt];
                ch[rgt] = tmp;
                lft++;
                rgt--;
            }
        }

        return new String(ch);
    }

    public static void main(String ...argv) {
        System.out.println(reverseStr("abcdefg", 2));

    }
}

package idv.paul.leetcode.leetcode75.easy;

/*
345. Reverse Vowels of a String

Given a string s, reverse only all the vowels in the string and return it.
The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:
Input: s = "hello"
Output: "holle"

Example 2:
Input: s = "leetcode"
Output: "leotcede"

Constraints:
1 <= s.length <= 3 * 105
s consist of printable ASCII characters.
*/

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString_345 {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('e'); vowels.add('i'); vowels.add('o'); vowels.add('u');
        vowels.add('A'); vowels.add('E'); vowels.add('I'); vowels.add('O'); vowels.add('U');

        char[] chars = s.toCharArray();
        int start = 0, end = chars.length-1;
        while (start < end) {
            boolean swappable = true;
            if (!vowels.contains(chars[start])) {
                start++;
                swappable = false;
            }
            if (!vowels.contains(chars[end])) {
                end--;
                swappable = false;
            }
            if (swappable) {
                char tmp = chars[start];
                chars[start] = chars[end];
                chars[end] = tmp;
                start++;
                end--;
            }
        }

        return new String(chars);
    }

    public static void main(String... argv) {
        String input = "leetcode";
        String output = new ReverseVowelsOfAString_345().reverseVowels(input);
        System.out.println(input + " has been transformed to " + output);
    }
}

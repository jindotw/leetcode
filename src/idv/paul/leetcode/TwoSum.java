package idv.paul.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 */

public class TwoSum {

    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cacheMap = new HashMap<>();

        for (int i=0; i<nums.length; ++i) {
            int num = nums[i];
            int difference = target - num;
            // System.out.println(String.format("num=%d, target=%d, diff=%d", num, target, difference));
            Integer cachedDiff = cacheMap.get(difference);
            if (cachedDiff == null) {
                // the idea is to cache the difference in the map
                cacheMap.put(num, i);
            } else {
                return new int[] { cachedDiff, i };
            }
        }
        return null;
    }

    public static void ans(int[] numbers, int target) {
        final int[] ans = twoSum(numbers, target);
        System.out.println("numbers=" + Arrays.toString(numbers) + ", target=" + target);
        if (ans != null) {
            System.out.println("Found answer at pos [" + ans[0] + ", " + ans[1] + "]");
        } else {
            System.out.println("Found no pair ");
        }
    }

    public static void main(String[] args) {
        ans(new int[] { 2, 11, 7, 15 }, 9);
        System.out.println();
        ans(new int[] { 3, 2, 4 }, 7);
        System.out.println();
        ans(new int[] { -3, 4, 3, 90 }, 0);
    }
}

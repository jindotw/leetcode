package idv.paul.leetcode.array;

/*
  https://leetcode.com/problems/3sum/
  Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
  Notice that the solution set must not contain duplicate triplets.

  Input: nums = [-1,0,1,2,-1,-4]
  Output: [[-1,-1,2],[-1,0,1]]
  Explanation:
  nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
  nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
  nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
  The distinct triplets are [-1,0,1] and [-1,-1,2].
  Notice that the order of the output and the order of the triplets does not matter.\

  Input: nums = [0,1,1]
  Output: []
  Explanation: The only possible triplet does not sum up to 0.

  Input: nums = [0,0,0]
  Output: [[0,0,0]]
  Explanation: The only possible triplet sums up to 0.
 */

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> combos = new ArrayList<>();
        // no possible solutions
        if (nums == null || nums.length < 3) {
            return combos;
        }
        Arrays.sort(nums);
        // populate HashMap
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i=0; i<nums.length; ++i) {
            cache.put(nums[i], i);
        }

        for (int i=0; i<nums.length-2; ++i) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i-1] == nums[i]) {
                continue;
            }
            for (int j=i+1; j<nums.length-1; ++j) {
                if (j > i+1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int key = -(nums[i] + nums[j]);

                if (cache.containsKey(key) && cache.get(key) > j) {
                    combos.add(Arrays.asList(nums[i], nums[j], key));
                }
            }
        }


        return combos;
    }

    public static void main(String... argv) {
        List<List<Integer>> combos = threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> combo : combos) {
            System.out.println(combo);
        }

    }
}

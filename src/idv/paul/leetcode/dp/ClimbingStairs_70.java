package idv.paul.leetcode.dp;

/*
Easy
https://leetcode.com/problems/climbing-stairs/

You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
public class ClimbingStairs_70 {
    // this is essentially a fibonacci sequence
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] memo = new int[n];
        memo[0] = 1;
        memo[1] = 2;

        for (int i=2; i<n; ++i) {
            memo[i] = memo[i-1] + memo[i-2];
        }

        return memo[n-1];
    }

    public static void main(String... argv) {
        int n = 3;
        int ways = climbStairs(n);
        System.out.printf("There are %d ways to climb the staircase\n", ways);
    }
}

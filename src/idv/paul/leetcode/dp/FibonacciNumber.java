package idv.paul.leetcode.dp;

public class FibonacciNumber {

    public static int fib(int n) {
        if (n <= 1)
            return n;

        int[] dp = new int[]{0, 1};
        for (int i=2; i<=n; ++i) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }

        return dp[1];
    }

    public static void  main(String... argv) {
        final int n = 30;
        System.out.println("The fibonacci of " + n + " is " + fib(n));
    }
}

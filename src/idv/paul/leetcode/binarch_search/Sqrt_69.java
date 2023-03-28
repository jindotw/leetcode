package idv.paul.leetcode.binarch_search;

public class Sqrt_69 {
    public static int mySqrt(int x) {
        int lo = 1, hi = x;
        int result = 0;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int sqrt = x / mid;
            // System.out.printf("lo=%d, hi=%d, mid=%d, sqrt=%d, result=%d\n", lo, hi, mid, sqrt, result);
            if (mid == sqrt) {
                return mid;
            } else if (sqrt < mid) {
                hi = mid - 1;
            } else {
                // mid is too low, continue in the upper half
                lo = mid +1;
                result = mid;
            }
            // System.out.printf("\tlo=%d, hi=%d, result=%d\n", lo, hi, result);
        }

        return result;
    }

    public static void main(String... argv) {
        int num = 1023;
        int sqrt = mySqrt(num);
        System.out.printf("sqrt of %d is %d\n", num, sqrt);
    }
}

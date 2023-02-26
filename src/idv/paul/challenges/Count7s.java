package idv.paul.challenges;

/**
 * <a href="https://stackoverflow.com/questions/7465149/number-frequency-or-number-of-9s-between-1-1000-java">...</a>
 * <p>
 * Let g(N) be the count of numbers that contain a 7 when you write out all the numbers from 1 to N
 * For example:
 *   g(7) = 1
 *   g(20) = 2
 *   g(70) = 8
 *   g(100) = 19
 * <p>
 *   Please answer the following tasks
 *   1. What is g(1000)?
 *   2. Write a computer program to compute g(N) and the test case to evaluate the program
 */

public class Count7s {
    public static int g(int N, int d) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            int num = i;
            while (num > 0) {
                if (num % 10 == d) {
                    count++;
                    break;
                }
                num /= 10;
            }
        }
        return count;
    }

    public static void main(String... args) {
        final int num = 1000;
        final int d = 7;
        int occurrences = g(num, d);
        System.out.println("the number of presence of " + d + " when counting from 1 to " + num + " is " + occurrences);
    }
}

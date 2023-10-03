package idv.paul.leetcode.backtracking;

/*
https://leetcode.com/problems/combination-sum-iii/
216. Combination Sum III
Medium

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

Constraints:

2 <= k <= 9
1 <= n <= 60
 */

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII_0216 {
	private final List<List<Integer>> matrix = new ArrayList<>();

	private void dfs(int start, int sum, int k, int n,List<Integer> path) {
		if (sum > n) {
			return;
		}
		if (path.size() == k && sum == n) {
			matrix.add(new ArrayList<>(path));
			return;
		}

		for (int i=start; i <= 9-(k-path.size())+1; i++) {
			sum += i;
			path.add(i);
			dfs(i+1, sum, k, n, path);
			path.remove(path.size()-1);
			sum -= i;
		}
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<Integer> path = new ArrayList<>();
		dfs(1, 0, k, n, path);


		return matrix;
	}

	public static void main(String ...argv) {
		int k = 3;
		int n = 9;
		CombinationSumIII_0216 instance = new CombinationSumIII_0216();
		List<List<Integer>> matrix = instance.combinationSum3(k, n);
		for (List<Integer> combo : matrix) {
			System.out.println(combo);
		}
	}
}

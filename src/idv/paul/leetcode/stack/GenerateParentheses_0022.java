package idv.paul.leetcode.stack;
/*
22. Generate Parentheses
Medium

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]

Constraints:

1 <= n <= 8
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GenerateParentheses_0022 {
	private final List<String> results = new ArrayList<>();
	private final Deque<Character> st = new ArrayDeque<>();

	private void dfs(int n, int openN, int closeN) {
		if (openN == closeN && openN == n) {
			StringBuilder sb = new StringBuilder();
			for (Character elem : st) {
				sb.append(elem);
			}
			results.add(sb.reverse().toString());
			return;
		}

		if (openN < n) {
			st.push('(');
			dfs(n, openN + 1, closeN);
			st.pop();
		}

		if (closeN < openN) {
			st.push(')');
			dfs(n, openN, closeN+1);
			st.pop();
		}
	}

	public List<String> generateParenthesis(int n) {
		dfs(n, 0, 0);
		return results;

	}

	public static void main(String ...argv) {
		int n = 3;
		List<String> results = new GenerateParentheses_0022().generateParenthesis(n);
		for (String result : results) {
			System.out.println(result);
		}
	}
}

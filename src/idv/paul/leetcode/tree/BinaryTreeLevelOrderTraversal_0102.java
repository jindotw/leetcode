package idv.paul.leetcode.tree;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal/description/
102. Binary Tree Level Order Traversal
Medium
14K
276
Companies
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).



Example 1:


Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000

Related Topics
Tree
Breadth-First Search
Binary Tree
 */

import idv.paul.leetcode.util.TreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversal_0102 {
	public static List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null)
			return Collections.emptyList();

		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> row = new LinkedList<>();
			result.add(row);
			for (int i=0; i<size; i++) {
				TreeNode node = queue.remove();
				row.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}


		return result;

	}

	public static void main(String ...argv) {
		TreeNode root = TreeNode.buildTree(new Integer[]{3,9,20,null,null,15,7});
		List<List<Integer>> result = levelOrder(root);
		for (List<Integer> row : result) {
			for (Integer e : row) {
				System.out.printf("%d ", e);
			}
			System.out.println();
		}
	}
}

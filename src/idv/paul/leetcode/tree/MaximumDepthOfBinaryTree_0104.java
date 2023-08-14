package idv.paul.leetcode.tree;
/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/1021059270/

104. Maximum Depth of Binary Tree
Easy
11.5K
191
Companies
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100

Related Topics
Tree
Depth-First Search
Breadth-First Search
Binary Tree
 */

import idv.paul.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree_0104 {

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		int depth = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i=0; i<size; i++) {
				TreeNode node = queue.remove();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			depth++;
		}
		return depth;
	}

	public static int maxDepth2(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));

	}

	public static void main(String ...argv) {
		TreeNode root = TreeNode.buildTree(new Integer[]{3,9,20,null,null,15,7});
		System.out.println(maxDepth2(root));
	}
}

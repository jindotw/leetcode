package idv.paul.leetcode.tree;

/*
https://leetcode.com/problems/symmetric-tree/description/
101. Symmetric Tree
Easy
14.1K
321
Companies
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:


Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:


Input: root = [1,2,2,null,3,null,3]
Output: false


Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100


Follow up: Could you solve it both recursively and iteratively?

Tree
Depth-First Search
Breadth-First Search
Binary Tree
 */

import idv.paul.leetcode.util.TreeNode;

import java.util.*;

public class SymmetricTree_0101 {

	public static boolean isSymmetric2(TreeNode root) {
		reverseTree(root.left);
		return isSameTree(root.left, root.right);
	}

	public static void reverseTree(TreeNode root) {
		if (root == null)
			return;

		reverseTree(root.left);
		reverseTree(root.right);

		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
	}

	public static boolean isSameTree(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}

		if (left == null || right == null || left.val != right.val) {
			return false;
		}

		return isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
	}

	public static boolean isSymmetric(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return true;

		queue.add(root.left);
		queue.add(root.right);

		while (!queue.isEmpty()) {
			TreeNode lft = queue.poll();
			TreeNode rgt = queue.poll();
			if (lft == null && rgt == null)
				continue;

			if (lft == null || rgt == null || lft.val != rgt.val)
				return false;


			queue.add(lft.left);
			queue.add(rgt.right);
			queue.add(lft.right);
			queue.add(rgt.left);
		}

		return true;
	}

	public static void main(String ...argv) {
		TreeNode root = TreeNode.buildTree(new Integer[]{1,2,2,3,4,4,3});
		System.out.println(isSymmetric2(root));
	}
}

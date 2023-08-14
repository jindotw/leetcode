package idv.paul.leetcode.tree;
/*
98. Validate Binary Search Tree
Medium
15.5K
1.3K
Companies
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left
subtree
 of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.


Example 1:


Input: root = [2,1,3]
Output: true
Example 2:


Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.


Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

Tree
Depth-First Search
Binary Search Tree
Binary Tree
 */

import idv.paul.leetcode.util.TreeNode;

public class ValidateBinarySearchTree_0098 {
	public static boolean isValidBST(TreeNode root) {
		return isValid(root, null, null);
	}

	public static boolean isValid(TreeNode root, Integer min, Integer max) {
		if (root == null)
			return true;

		if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
			return false;
		}

		return isValid(root.left, min, root.val) && isValid(root.right, root.val, max);
	}

	public static void main(String ...argv) {
		TreeNode root = TreeNode.buildTree(new Integer[]{0, -1});

		System.out.println(isValidBST(root));
	}
}

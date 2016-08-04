package leetcode.easy;

import org.junit.Test;

import tools.TreeNode;

/**
101. Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following [1,2,2,null,3,null,3] is not:
    1
   / \
  2   2
   \   \
   3    3
*/
public class NO101 {
	@Test
	public void test() {
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null)
			return right == null;
		if (right == null)
			return false;
		if (left.val != right.val)
			return false;
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
}

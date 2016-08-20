package 基础算法.遍历;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import 工具类.TreeNode;

public class 树的遍历 {
	/**
	 * 用数组初始化的是完全二叉树
	 * 如{-1,1,2,3,-1,4}
	 * 1. 索引0不考虑
	 * 2. 没有值的地方填-1(不考虑树中有负值的情况)
	 * @param arr
	 * @return
	 */
	public static TreeNode 建树(int[] arr) {
		if (arr == null || arr.length == 0)
			return null;
		List<TreeNode> list = new ArrayList<TreeNode>();
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || arr[i] == -1)
				list.add(null);
			else
				list.add(new TreeNode(arr[i]));
		}
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i) == null)//空结点没有左右子树
				continue;
			if (2 * i < list.size()) {//加左子树
				list.get(i).left = list.get(2 * i);
			} else {
				list.get(i).left = null;
			}

			if (2 * i + 1 < list.size()) {//加右子树
				list.get(i).right = list.get(2 * i + 1);
			} else {
				list.get(i).right = null;
			}
		}
		return list.get(1);
	}

	public static void 层次遍历(TreeNode tree) {
		if (tree == null)
			return;
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(tree);
		while (queue.size() != 0) {
			TreeNode node = queue.remove();
			System.out.println(node.val);
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
		}
	}

	public static void 前序遍历(TreeNode tree) {
		if (tree != null) {
			System.out.println(tree.val);
			前序遍历(tree.left);
			前序遍历(tree.right);
		}
	}

	public static void 中序遍历(TreeNode tree) {
		if (tree != null) {
			中序遍历(tree.left);
			System.out.println(tree.val);
			中序遍历(tree.right);
		}
	}

	public static void 后序遍历(TreeNode tree) {
		if (tree != null) {
			System.out.println(tree.val);
			后序遍历(tree.left);
			后序遍历(tree.right);
		}
	}
}

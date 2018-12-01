package 剑指offer;

import java.util.ArrayList;
import java.util.List;

import tools.TreeNode;

/**
 * 
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列
 * {4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 
 * @author lv
 *
 */
public class 重建二叉树 {

	public static void main(String[] args) {
		int[] pre = { 1, 2, 3, 4, 5, 6, 7 };
		int[] in = { 3, 2, 4, 1, 6, 5, 7 };
		reConstructBinaryTree(pre, in);
	}

	public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre == null || pre.length == 0)
			return null;
		TreeNode node = new TreeNode(pre[0]);
		List<Integer> beforeInList = new ArrayList<>();
		List<Integer> afterInList = new ArrayList<>();
		boolean isPre = true;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == pre[0]) {
				isPre = false;
				continue;
			}
			if (isPre)
				beforeInList.add(in[i]);
			else
				afterInList.add(in[i]);
		}

		List<Integer> beforePreList = new ArrayList<>();
		List<Integer> afterPreList = new ArrayList<>();
		for (int i = 1; i < pre.length; i++) {
			if (beforeInList.contains(pre[i])) {
				beforePreList.add(pre[i]);
			} else {
				afterPreList.add(pre[i]);
			}
		}
		TreeNode left = reConstructBinaryTree(toIntArray(beforePreList), toIntArray(beforeInList));
		TreeNode right = reConstructBinaryTree(toIntArray(afterPreList), toIntArray(afterInList));
		node.left = left;
		node.right = right;
		return node;
	}

	public static int[] toIntArray(List<Integer> list) {
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}
}

package 互联网公司.网易;

import java.util.HashSet;

import tools.TreeNode;
import 互联网公司.网易.二叉树.ReverseTree;

/**
 * 有一棵二叉树，树上每个点标有权值，权值各不相同，请设计一个算法
 * 算出权值最大的叶节点到权值最小的叶节点的距离。二叉树每条边的距
 * 离为1，一个节点经过多少条边到达另一个节点为这两个节点之间的距离。
 * 
 * 给定二叉树的根节点root，请返回所求距离。
 * @author lv
 *
 */
public class 二叉树 {
	private static void xxx() {
		System.out.println("--------");
	}

	public static void main(String[] args) {
		((二叉树) null).xxx();
	}

	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;

	class ReverseTree {
		int val;
		ReverseTree next;

		public ReverseTree(int val, ReverseTree next) {
			this.val = val;
			this.next = next;
		}
	}

	ReverseTree pre = null;

	private ReverseTree initReverseTree(TreeNode root, int target) {
		while (root != null) {
			ReverseTree reversetree;
			if (pre != null) {
				reversetree = new ReverseTree(root.val, pre);
			} else {
				reversetree = new ReverseTree(root.val, null);
			}
			pre = reversetree;
			if (root.val == target)
				return reversetree;
			initReverseTree(root.left, target);
			initReverseTree(root.right, target);
		}
		return null;
	}

	public int getDis(TreeNode root) {
		if (root == null)
			return 0;
		getMaxMin(root);
		ReverseTree reverseTreeMax = initReverseTree(root, max);
		ReverseTree reverseTreeMin = initReverseTree(root, min);
		HashSet<ReverseTree> set = new HashSet<>();
		int len = 0;
		while (reverseTreeMax != null || reverseTreeMin != null) {
			if (reverseTreeMax != null) {
				if (set.contains(reverseTreeMax)) {
					break;
				}
				len++;
				set.add(reverseTreeMax);
				reverseTreeMax = reverseTreeMax.next;
			}
			if (reverseTreeMin != null) {
				if (set.contains(reverseTreeMin)) {
					break;
				}
				len++;
				set.add(reverseTreeMin);
				reverseTreeMin = reverseTreeMin.next;
			}
		}
		return len;
	}

	private void getMaxMin(TreeNode root) {
		while (root != null) {
			getMaxMin(root.left);
			if (root.left == null && root.right == null) {
				max = Math.max(root.val, max);
				min = Math.min(root.val, min);
			}
			getMaxMin(root.right);
		}
	}
}

package 基础算法.遍历;

import org.junit.Test;

import 工具类.TreeNode;

public class 树的遍历Test {

	@Test
	public void test建树() {
		/*
		 这个树的形状如下:
		             1
		            / \
		           2   3
		            \
		             4  
		 */
		树的遍历.建树(new int[] { -1, 1, 2, 3, -1, 4 });
	}

	@Test
	public void test层次遍历() {
		TreeNode tree = 树的遍历.建树(new int[] { -1, 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		树的遍历.层次遍历(tree);
	}

	@Test
	public void test前序遍历() {
		TreeNode tree = 树的遍历.建树(new int[] { -1, 1, 2, 3, -1, 4 });
		树的遍历.前序遍历(tree);
	}

	@Test
	public void test中序遍历() {
		TreeNode tree = 树的遍历.建树(new int[] { -1, 1, 2, 3, -1, 4 });
		树的遍历.中序遍历(tree);
	}

	@Test
	public void test后序遍历() {
		TreeNode tree = 树的遍历.建树(new int[] { -1, 1, 2, 3, -1, 4 });
		树的遍历.后序遍历(tree);
	}

}

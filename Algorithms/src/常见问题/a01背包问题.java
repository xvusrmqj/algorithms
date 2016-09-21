package 常见问题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定n个重量为w1,w2...wn，价值为v1,v2,...vn的物品和一个承重为W的背包。
 * 求这些物品中的一个最有价值的子集。
 * 
 * 还有好多背包问题啊：http://love-oriented.com/pack/
 * @author lv
 *
 */
public class a01背包问题 {
	@Test
	public void test() {
		Assert.assertEquals(65,
				动态规划(new int[] { 7, 3, 4, 5 }, //
						new int[] { 42, 12, 40, 25 }, //
						10));
		Assert.assertEquals(58,
				动态规划(new int[] { 37, 40, 16, 30, 18 }, //
						new int[] { 37, 40, 16, 30, 18 }, //
						60));
		Assert.assertEquals(99,
				动态规划(new int[] { 57, 46, 32, 23, 44, 38, 78, 32, 57, 25 }, //
						new int[] { 57, 46, 32, 23, 44, 38, 78, 32, 57, 25 }, //
						100));
	}

	public int 穷举法(int[] wArr, int[] vArr, int W) {
		List<Integer> listW = new ArrayList<>();
		List<Integer> listV = new ArrayList<>();
		for (int i = 0; i < wArr.length; i++) {
			int size = listW.size();
			for (int j = 0; j < size; j++) {
				if (listW.get(j) + wArr[i] <= W) {
					listW.add(listW.get(j) + wArr[i]);
					listV.add(listV.get(j) + vArr[i]);
				}
			}
			if (wArr[i] <= W) {
				listW.add(wArr[i]);
				listV.add(vArr[i]);
			}
		}
		return Collections.max(listV);
	}

	public int 动态规划(int[] wArr, int[] vArr, int W) {
		int n = wArr.length;
		int[][] dp = new int[n][W];
		for (int i = 1; i < n; ++i) {
			for (int j = 1; j < W; ++j) {
				if (wArr[i] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - wArr[i]] + vArr[i]);
				}
			}
		}
		return dp[n - 1][W - 1];
	}

	/**
	 * 王道程序员面试宝典P240
	 */
	private class 穷举法2 {
		public int 穷举法(int[] wArr, int[] vArr, int W) {
			dfs(wArr, 0, vArr, 0, 0, W);
			return max;
		}

		private int max = 0; //如果使用静态变量， 几个测试用例一起测会有干扰。

		private void dfs(int[] wArr, int sumW, int[] vArr, int sumV, int ceng, int W) {
			if (sumW > W) {
				return;
			}
			max = Math.max(max, sumV);
			if (ceng == wArr.length) {
				return;
			}
			++ceng;
			dfs(wArr, sumW, vArr, sumV, ceng, W);
			dfs(wArr, sumW + wArr[ceng - 1], vArr, sumV + vArr[ceng - 1], ceng, W);
		}
	}
}

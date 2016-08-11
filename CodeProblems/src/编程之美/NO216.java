package 编程之美;

/**
 * 求数组中最长递增子序列
 * @author lv
 *
 */
public class NO216 {

	public static void main(String[] args) {
		int[][] arr = { { 9, 10, 1, 2, 3 }, //3	
				{}, //0
				{ 1 }, //1
				{ 1, 1, 1 }, //1
				{ 1, -1, 2, 1, 5 }, //3
		};
		for (int i = 0; i < arr.length; i++) {
			System.out.println(fun(arr[i]));
		}
	}

	public static int fun(int[] A) {
		if (A == null || A.length == 0)
			return 0;
		int[] dp = new int[A.length];//保存以i结尾的最长长度,必须有i
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		int max = dp[0];
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(max, dp[i]);
		}
		return max;
	}

}

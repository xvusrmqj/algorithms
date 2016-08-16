package 互联网公司.网易;

import static java.lang.Math.*;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照
顺序选取 k 名学生，要求相邻两个学生的位置编号的差不超过 d，使得这 k 个
学生的能力值的乘积最大，你能返回最大的乘积吗？ 

输入描述:
每个输入包含 1 个测试用例。每个测试数据的第一行包含一个整数 n (1 <= n <= 50)，
表示学生的个数，接下来的一行，包含 n 个整数，按顺序表示每个学生的能力值
 a_i（-50 <= a_i <= 50）。接下来的一行包含两个整数，k 和 d (1 <= k <= 10, 1 <= d <= 50)。


输出描述:
输出一行表示最大的乘积。

输入例子:
3
7 4 7
2 50

输出例子:
49
 * @author lv
 *
 */
public class 合唱团 {

	public static void main(String[] args) {
		int[] arr = { 3, 9, -7, -7 };
//		int[] arr = { 7, 49, -47, -47 };
		int n = arr.length;
		int k = 3;
		int d = 31;
		long res = fun(n, arr, k, d);
		System.out.println(res);
		/*Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = Integer.parseInt(sc.nextLine());
			int[] arr = trans(sc.nextLine().split(" "));
			int k = sc.nextInt();
			int d = sc.nextInt();
			long res = fun(n, arr, k, d);
			System.out.println(res);
		}
		sc.close();*/
	}

	private static long fun(int n, int[] arr, int k, int d) {
		long[][] dpm = new long[n][k];
		long[][] dpn = new long[n][k];
		long res = 0L;
		for (int i = 0; i < arr.length; i++) {
			dpm[i][0] = arr[i];
			dpn[i][0] = arr[i];
			for (int j = 1; j < k && j <= i; j++) {
				for (int m = i - 1; m >= 0 && m >= i - d; m--) {
					dpm[i][j] = max(dpm[i][j], max(dpm[m][j - 1] * arr[i], dpn[m][j - 1] * arr[i]));
					dpn[i][j] = min(dpn[i][j], min(dpm[m][j - 1] * arr[i], dpn[m][j - 1] * arr[i]));
				}
			}
		}
		for (int i = 0; i < dpm.length; i++) {
			for (int j = 0; j <= i && j < k; j++) {
				res = max(res, dpm[i][j]);
			}
			System.out.println(Arrays.toString(dpm[i]));
		}
		return res;
	}

	private static int[] trans(String[] arr) {
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = Integer.parseInt(arr[i]);
		}
		return res;
	}

}

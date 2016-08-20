package 基础算法.排序.基础排序;

import java.util.Arrays;

import org.junit.Test;

public class 冒泡排序 {

	@Test
	public void test() {
		sort(new int[] { 1, 2, 3, 4 });
		sort(new int[] { 4, 3, 2, 1 });
		sort(new int[] { 1, 1, 1, 2, 3, 4, 4 });
		sort(new int[] { 5, 3, 6, 34, 7, 9, 2, 1 });
	}

	/**
	 * i	[len-1, 0]
	 * j	[0, i-1]
	 * @param arr
	 */
	public void sort(int[] arr) {
		System.out.println("begin:" + Arrays.toString(arr));
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = tmp;
				}
			}
		}
		System.out.println("after:" + Arrays.toString(arr));
	}
}

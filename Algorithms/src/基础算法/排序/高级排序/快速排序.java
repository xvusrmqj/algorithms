package 基础算法.排序.高级排序;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author lv
 *
 */
public class 快速排序 {
	@Test
	public void test() {
		test1(new int[] { 2, 3, 2, 5, 7, 2, 5, 6, 10, 1, 1 });//有重
		test1(new int[] { 10, 9, 7, 6, 5 });//逆序
		test1(new int[] { 10, 10, 10, 10, 9, 9, 9, 8, 8, 8 });//有重且逆序
		test1(new int[] {});
	}

	private void test1(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public void quickSort(int[] arr, int lo, int hi) {
		if (lo >= hi)
			return;
		int pivot = partition(arr, lo, hi);
		quickSort(arr, lo, pivot - 1);
		quickSort(arr, pivot + 1, hi);
	}

	/**
	 * 注意: 
	 * 1. 内部的两个while循环必须判断lo<hi
	 * 2. 内部的两个while循环前面的判断必须加=,否则有重元素会造成死循环
	 * @param arr
	 * @param lo
	 * @param hi
	 * @return
	 */
	private int partition(int[] arr, int lo, int hi) {
		int target = arr[lo];//1. 把第1个元素拿出
		while (lo < hi) { //2. 将左边右边排好
			while (arr[hi] >= target && lo < hi)
				hi--;
			arr[lo] = arr[hi];
			while (arr[lo] <= target && lo < hi)
				lo++;
			arr[hi] = arr[lo];
		}
		arr[lo] = target;//3. 将拿出的放到最后剩余的空里.
		return lo;
	}
}

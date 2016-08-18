package 基础算法.排序.基础排序;

import java.util.Arrays;

import org.junit.Test;

public class 选择排序 {
	@Test
	public void test() {
		//		1. null  
		fun(null);
		//		2. {}
		fun(new int[] {});
		//		3. 无重，无序
		fun(new int[] { 3, 2, 5, 7, 8, 1 });
		//		5. 无重，正序‘
		fun(new int[] { 2, 3, 4, 5, 6 });
		//		4. 无重，反序
		fun(new int[] { 6, 5, 4, 3, 2, 1 });
		//		5. 有重，无序‘
		fun(new int[] { 2, 3, 2, 3, 4, 7, 6 });
		//		5. 有重，正序‘
		fun(new int[] { 2, 2, 2, 3, 4, 5, 6 });
		//		6. 有重，反序
		fun(new int[] { 6, 5, 4, 3, 3, 2, 2 });
	}

	/**
	 * 变量及其范围
	 * i: [0，n-1]
	 * j: [i, n-1]
	 * @param arr
	 */
	public void fun(int[] arr) {
		if (arr == null || arr.length == 0)
			return;
		System.out.println("排序前：" + Arrays.toString(arr));
		
		for (int i = 0; i < arr.length; i++) {//有序范围
			int minIndex = i;
			for (int j = i; j < arr.length; j++) {//无序范围
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			int tmp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = tmp;
		}
		
		System.out.println("排序后：" + Arrays.toString(arr));
		System.out.println("----------------------");
	}
}

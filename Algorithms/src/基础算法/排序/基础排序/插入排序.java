package 基础算法.排序.基础排序;

import java.util.Arrays;

import org.junit.Test;

public class 插入排序 {
	@Test
	public void test() {
		//		1. null
		fun(null);
		//		2. {}
		fun(new int[]{});
		//		3. 无重，无序
		fun(new int[]{3,2,5,7,8,1});
		//		5. 无重，正序‘
		fun(new int[]{2,3,4,5,6});
		//		4. 无重，反序
		fun(new int[]{6,5,4,3,2,1});
		//		5. 有重，无序‘
		fun(new int[]{2,3,2,3,4,7,6});
		//		5. 有重，正序‘
		fun(new int[]{2,2,2,3,4,5,6});
		//		6. 有重，反序
		fun(new int[]{6,5,4,3,3,2,2});
	}

	/**
	 * 变量及其范围
	 * i: [1, n-1]
	 * j: [i-1, 0]
	 * @param arr
	 */
	public void fun(int[] arr) {
		if(arr==null||arr.length==0) return;
		System.out.println("排序前：" + Arrays.toString(arr));
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if (arr[j] < arr[j-1]) {
					int tmp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = tmp;
				}else
					break;
			}
		}
		System.out.println("排序后：" + Arrays.toString(arr));
		System.out.println("----------------------");
	}
}

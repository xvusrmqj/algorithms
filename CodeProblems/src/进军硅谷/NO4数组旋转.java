package 进军硅谷;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author lv
 *
 */
public class NO4数组旋转 {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		fun(arr, 2);// out: 4,5,6,7,8,9,1,2,3
		System.out.println(Arrays.toString(arr));
	}

	// 
	public static void fun(int[] arr, int k) {
		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, arr.length - k - 2);
		reverse(arr, arr.length - k - 1, arr.length - 1);
	}

	public static void reverse(int[] arr, int begin, int end) {
		if (begin > end)
			throw new RuntimeException("input ilegal!");
		for (int i = begin, j = end; i < j; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}

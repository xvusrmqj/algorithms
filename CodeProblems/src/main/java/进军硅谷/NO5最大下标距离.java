package 进军硅谷;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整型数组,找出最大下标距离j-i, 当且仅当A[i]<A[j]和i<j
 * @author lv
 *
 */
public class NO5最大下标距离 {

	public static void main(String[] args) {

		int[][] array = { { 5, 3, 4, 0, 1, 4, 1 }//4
				, { 1, 2, 3, 4, 5, 6, 7 }//6
				, { 0, 0, 0 }//0
				, {}//0
		};
		for (int i = 0; i < array.length; i++) {
			int maxLen = fun1(array[i]);
			System.out.println(maxLen);
		}
	}

	//穷举法: 每两个元素都比一遍.O(n^2)
	public static int fun1(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					max = Math.max(max, j - i);
				}
			}
		}
		return max;
	}

	//本题有两个限制条件,一个是位置关系, 一个是值的关系.
	//先把值的关系搞出来: 排序--->会改变位置---->用HashMap<值,索引>把位置记下来.
	//再把位置关系搞出来: 
	public static int fun2(int[] arr) {
		//先用查找表把位置记录下来，但是如果值重复了就完了。。。。。
		Map<Integer,Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}
		//再排序
		Arrays.sort(arr);//
		//两个指针一头一尾，这个就是最大距离。
		return 0;
	}
	//先
	public static int fun3(int[] arr) {
		return 0;
	}

	public static int fun4(int[] arr) {
		return 0;
	}

	public static int fun5(int[] arr) {
		return 0;
	}

}

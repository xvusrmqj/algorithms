package 基础算法.查找;

import static org.junit.Assert.*;
import org.junit.Test;

public class 二分查找 {
	@Test
	public void test() {
		//1. 无重， 查找成功
		assertEquals(fun(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 1), //input
				0);//excepted: 0

		//2. 无重，查找失败
		assertEquals(fun(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 0), //input
				-1);//excepted:-1

		//3. 有重，查找成功
		assertEquals(fun(new int[] { 1, 1, 3, 4, 5, 6, 7, 8, 9, 10 }, 1), //input
				1);//excepted:1

		//4. 有重，查找失败
		assertEquals(fun(new int[] { 1, 1, 3, 4, 5, 6, 7, 8, 9, 10 }, 0), //input
				-1);//excepted:-1

		//5. null
		assertEquals(fun(null, 1), //input
				-1);//excepted:-1

		//6. {}
		assertEquals(fun(new int[] {}, 1), //input
				-1);//excepted:-1

	}

	/**
	 * 二分查找
	 * 1. 需要几个变量? 分别表示什么?
	 * 	 - begin  : 范围起始点
	 * 	 - end	  : 范围结束点
	 *   - medium : 判断点
	 * 2. 每个变量的范围是多少?
	 * 	 - begin = begin 或  medium+1		(arr[medium]>target)
	 *   - end = end 或 medium -1		(arr[medium]<target)
	 *   - medium = (begin+end)/2
	 * @param arr
	 * @param target
	 * @return
	 */
	private int fun(int[] arr, int target) {
		if (arr == null || arr.length == 0)
			return -1;
		int begin = 0;
		int end = arr.length - 1;
		int medium = (begin + end) / 2;
		while (begin <= end) {
			if (arr[medium] == target) {
				return medium;
			} else if (arr[medium] < target) {
				begin = medium + 1;
				medium = (begin + end) / 2;
			} else {
				end = medium - 1;
				medium = (begin + end) / 2;
			}
		}
		return -1;
	}
}

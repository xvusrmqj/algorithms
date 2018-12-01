package 剑指offer;

import static org.junit.Assert.*;
import org.junit.Test;

/**
把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author lv
 *
 */
public class S8旋转数组的最小数字 {

	@Test
	public void test() {
		assertEquals(0, //
				test1(new int[] { 6, 7, 8, 9, 1 }, 6));
		assertEquals(4, //
				test1(new int[] { 6, 7, 8, 9, 1 }, 1));
		assertEquals(0, //
				test1(new int[] { 5, 1, 2, 3, 4 }, 5));
		assertEquals(1, //
				test1(new int[] { 5, 1, 2, 3, 4 }, 1));
		assertEquals(-1, //
				test1(new int[] { 1, 2, 3, 4, 5 }, 0));
	}

	private int test1(int[] arr, int target) {
		return minNumberInRotateArray(arr, 0, arr.length - 1, target);
	}

	public int minNumberInRotateArray(int[] arr, int b, int e, int target) {
		if (b > e)
			return -1;
		int medium = (b + e) / 2;
		if (arr[medium] == target)
			return medium;
		if (medium == b) {
			return minNumberInRotateArray(arr, medium + 1, e, target);
		} else {
			if (arr[medium] > arr[b]) {
				//左有序，右无序
				if (target > arr[medium]) {
					return minNumberInRotateArray(arr, medium + 1, e, target);
				} else {
					if (target < arr[b]) {
						return minNumberInRotateArray(arr, medium + 1, e, target);
					} else {
						return minNumberInRotateArray(arr, b, medium - 1, target);
					}
				}
			} else {
				//左无序，右有序
				if (target > arr[medium]) {
					if (target > arr[e]) {
						return minNumberInRotateArray(arr, b, medium - 1, target);
					} else {
						return minNumberInRotateArray(arr, medium + 1, e, target);
					}
				} else {
					return minNumberInRotateArray(arr, b, medium - 1, target);
				}
			}
		}
	}

}

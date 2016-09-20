package 常见问题;

import org.junit.Test;

/**
 * 列出给定元素的所有组合
 * 1,2,3的组合为{1,2,3,12,13,23,123}
 * @author lv
 *
 */
public class 组合生成算法 {
	@Test
	public void test() {
		intCreator(new int[] { 1, 2, 3 }, 0, 0);
		System.out.println();
		stringCreator(new String[] { "A", "B", "C" }, 0, "");
	}

	private void stringCreator(String[] arr, int ceng, String s) {
		if (ceng == arr.length) {
			System.out.print(s + ",");
			return;
		}
		++ceng;
		stringCreator(arr, ceng, s + arr[ceng - 1]);
		stringCreator(arr, ceng, s);
	}

	private void intCreator(int[] arr, int ceng, int s) {
		if (ceng == arr.length) {
			System.out.print(s + ",");
			return;
		}
		++ceng;
		intCreator(arr, ceng, s + arr[ceng - 1]);
		intCreator(arr, ceng, s);
	}
}

package JavaSE.常用工具类;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 1.Comparable与Comparator。
 * Comparable相当于“内部比较器”，而Comparator相当于“外部比较器”。
 * 内部比较器一般是按自然顺序比较，而外部比较器我们可以自定义。
 * 
 * 2. 比较器的返回值 : 
 * 默认为递增排序， a<b return -1; a>b return 1;递减排序反之。
 * 
 * @author lv
 *
 */
public class 比较器 {
	public static void main(String[] args) {
		String[] s = { "a", "bb", "cc", "aaa", "b", "c", "aa", "bbb", "ccc" };
		//		打印前后比较(s);
		Arrays.sort(s, new MyComparator());
		printArray(s);
	}

	private static void 各种排序() {

		//	* 1. 数组排序: Arrays类
		String[] s = { "a", "bb", "cc", "aaa", "b", "c", "aa", "bbb", "ccc" };
		Arrays.sort(s, new MyComparator());
		//	* 2. List排序: Collections类
		List<String> list = Arrays.asList(s);
		Collections.sort(list);
		//	* 3. Set排序 : 转成List再排序
		Set<String> set = new HashSet<>();
		List<String> list2 = Arrays.asList(s);
		list2.addAll(set);
		Collections.sort(list2);

	}

	// 默认的打印结果: a->aa->aaa->b->bb->bbb->c->cc->ccc->
	// 自定义比较器打印结果:a->b->c->bb->cc->aa->aaa->bbb->ccc->
	private static void 打印前后比较(String[] s) {
		//		Arrays.sort(s); // 默认打印
		Arrays.sort(s, new MyComparator());
		printArray(s);
	}

	private static void printArray(String[] s) {
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + "->");
		}
	}

	static class MyComparator implements Comparator<String> {

		@Override
		public int compare(String o1, String o2) {
			if (o1.length() < o2.length()) {
				return -1;
			} else if (o1.length() > o2.length()) {
				return 1;
			}
			return o1.compareTo(o2);
		}

	}
}

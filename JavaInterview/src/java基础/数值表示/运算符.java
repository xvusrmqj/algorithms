package java基础.数值表示;

import org.junit.Test;

/**
 * java 语言中只有单目运算符、赋值运算符和三目运算符是从右向左运算的，
 * 其它运算符都是从左向右运算的。
 * @author lv
 *
 */
public class 运算符 {
	public static void main(String[] args) {
		移位运算符();
	}

	/**
	 * <<:  左移
	 * >>:  右移
	 * >>>: 无符号右移
	 */
	@Test
	private static void 移位运算符() {
		int i = 4;
		System.out.println(i>>1);
		System.out.println(i>>>1);
		int j = -4;
		System.out.println(j>>1);
		System.out.println(j>>>1);
	}
}

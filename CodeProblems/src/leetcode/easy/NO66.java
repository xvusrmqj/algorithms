package leetcode.easy;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 66. Plus One
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class NO66 {
	@Test
	public void test() {
	}

	public int[] plusOne(int[] digits) {
		int[] carry = new int[digits.length + 1]; //进位数组, 有可能比原数组进位后多一位.
		carry[digits.length] = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			if (digits[i] == 9 && carry[i + 1] == 1) {
				carry[i] = 1;
				digits[i] = 0;
			} else {
				digits[i] += carry[i + 1];
			}
		} // 至此, digits里的元素都正常改变了.就看多不多一位.

		if (carry[0] == 1) { // 多一位的情况, 把digit里的元素都拷贝到新数组让新数组首位为1 返回新数组.
			for (int i = 1; i < carry.length; i++) {
				carry[i] = digits[i - 1]; //正好carry数组没用了, 就用它吧.
			}
			return carry;
		} else { // digits数组里的元素不多一位,正常返回就行.
			return digits;
		}
	}
}

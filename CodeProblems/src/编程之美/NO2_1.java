package 编程之美;

import org.junit.Assert;
import org.junit.Test;

/**
 * 求二进制中1的个数
 * @author lv
 *
 */
public class NO2_1 {
	@Test
	//测试与1进行移位操作：负数的右移前面补1
	public void testBitOne() {
		String s = Integer.toBinaryString(-1);
		System.out.println(s);
		String s2 = Integer.toBinaryString(-1 >> 1);
		System.out.println(s2);

	}

	@Test
	public void test() {
		Assert.assertEquals(0, count(0));
		Assert.assertEquals(1, count(1));
		Assert.assertEquals(1, count(2));
		Assert.assertEquals(2, count(3));
		Assert.assertEquals(1, count(4));
		Assert.assertEquals(2, count(5));
		
		Assert.assertEquals(2, count(-1));
		Assert.assertEquals(2, count(-2));
		Assert.assertEquals(3, count(-3));
	}

	int count(int i) {
		boolean fushu = false;
		if (i < 0)
			fushu = true;
		i = Math.abs(i);
		int sum = 0;
		while (i != 0) {
			if ((i & 1) == 1)
				sum++;
			i >>= 1;
		}
		return fushu?sum+1:sum;
	}

}

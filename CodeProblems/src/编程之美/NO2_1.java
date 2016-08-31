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
		String s3 = Integer.toBinaryString(-1 >>> 1);
		System.out.println(s3);

	}

	@Test
	public void testCount1() {
//		Assert.assertEquals(0, count1(0));
//		Assert.assertEquals(1, count1(1));
//		Assert.assertEquals(1, count1(2));
//		Assert.assertEquals(2, count1(3));
//		Assert.assertEquals(1, count1(4));
//		Assert.assertEquals(2, count1(5));
//		Assert.assertEquals(32, count1(-1));
//		Assert.assertEquals(31, count1(-2));
//		Assert.assertEquals(31, count1(-3));
		
		Assert.assertEquals(0, count2(0));
		Assert.assertEquals(1, count2(1));
		Assert.assertEquals(1, count2(2));
		Assert.assertEquals(2, count2(3));
		Assert.assertEquals(1, count2(4));
		Assert.assertEquals(2, count2(5));
		Assert.assertEquals(32, count2(-1));
		Assert.assertEquals(31, count2(-2));
		Assert.assertEquals(31, count2(-3));
	}
	//向右移位, 需要判断所有位
	int count1(int i) {
		int sum = 0;
		while (i != 0) {
			if ((i & 1) == 1)
				sum++;
			i >>>= 1;//注意负数向右移位的问题,应该使用无符号右移.
		}
		return sum;
	}
	//只需判断1的个数.
	int count2(int i){
		int sum = 0;
		while(i!=0){
			i&=i-1;
			sum++;
		}
		return sum;
	}

}

package commonOperations;
import java.util.BitSet;
import java.util.Random;

import org.junit.Test;

/**
 * the size of primitive data type.
 * boolean: vm dependency.
 * byte:8bit
 * short:16bit
 * int:32bit
 * long:64bit
 * float:32bit
 * double:64bit 
 * char:16bit
 * 
 * note:If you are thinking about using an array of Boolean objects, don't 
 * use boolean[]. Use a BitSet instead - it has some performance optimizations
 * (and some nice extra methods, allowing you to get the next set/unset bit)
 * 
 * @see http://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
 * @author lv
 */
public class NumberTest {
	//Math类中有很多实用的方法
	@Test
	public void testMathClass(){
		//PI , e
		System.out.println(Math.E);
		System.out.println(Math.PI);
		// 向上取整, 向下取整, 四舍五入 
		System.out.println(Math.ceil(11.2));
		System.out.println(Math.ceil(11));
		System.out.println(Math.floor(11.2));
		System.out.println(Math.floor(11));
		System.out.println(Math.round(11.2));
		// max and min
		// if(a>b) return a; else return b <==> return a>b?a:b <==> return max(a,b);
		System.out.println(Math.max(1, 2));
		System.out.println(Math.min(1, 2));
		//平方根, 立方根, 乘方
		System.out.println(Math.sqrt(4));
		System.out.println(Math.cbrt(8));
		System.out.println(Math.pow(2,3));
		//对数
		System.out.println(Math.log(Math.E));//e
		System.out.println(Math.log10(10));//10
		//绝对值
		System.out.println(Math.abs(-4));
		//随机数
		System.out.println(Math.random());//the value belong to [0.0,1.0]
		// random is a better choice
		System.out.println(new Random().nextInt(8));
		System.out.println(new Random().nextInt());
		System.out.println(new Random().nextFloat());
	}
	@Test
	// BitSet is just like an boolean array which grows as needed.
	/**
	 * test bitset basic method : set()get()clear()size()length()isempty()
	 */
	public void bitSetBasicTest() {
		BitSet bs = new BitSet();
		bs.set(0); // the index 0 is set to be true;
		bs.set(5); // the index 5 is set to be true;
		System.out.println("the index 0 is:" + bs.get(0));// true
		System.out.println("bitset length:" + bs.length());// logic size =
															// maxIndex+1
		System.out.println("bitset size:" + bs.size());// real size
		bs.clear(0);
		System.out.println(bs.get(0));// false
		bs.clear();// clear all
		System.out.println("bitset is empty:" + bs.isEmpty());// true
		System.out.println("bitset length:" + bs.length());// 0
	}

	@Test
	/**
	 * test two bitset operation: and()andNot()or()xor()
	 */
	public void twoBitsetOperation() {
		BitSet bs1 = new BitSet();
		BitSet bs2 = new BitSet();
		bs1.set(0);
		bs2.set(1);
		// now the bs1 is 100,bs2 is 010
		System.out.println("bs1=" + bs1 + ",bs2=" + bs2);
		bs1.and(bs2);// 100&010 = 000, bs2 not change
		System.out.println("bs1=" + bs1 + ",bs2=" + bs2);
		bs1.or(bs2);// 000|010 = 010, bs2 not change
		System.out.println("bs1=" + bs1 + ",bs2=" + bs2);
		bs1.xor(bs2);// 010⊕010 = 000, bs2 not change
		System.out.println("bs1=" + bs1 + ",bs2=" + bs2);
		bs1.andNot(bs2);// I don't know the andNot() method means.is it = !(bs1&bs2)?
		System.out.println("bs1=" + bs1 + ",bs2=" + bs2);
	}
}

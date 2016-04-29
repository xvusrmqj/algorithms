package commonOperations;
import java.util.BitSet;

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

package commonOperations;

/**
 * 参考：程序员面试金典P55位操作
 * 
 * @author lv
 *
 */
public class 位操作 {
	public static void main(String[] args) {
		//test 把“11110000,10101010,00001111，10011100中的第5~8位清零。
		int i = Integer.parseInt("-1110000101010100000111110011100", 2);//最前面是负时不要写1，而是写负号。
		//1. 先找掩码：11111111，11111111，11111111，00001111.
		int mask = (~0 << 8) | ((1 << 4) - 1);
		//2. 测试显示正确
		String binaryString = Integer.toBinaryString(mask);
		System.out.println(binaryString);
		//3. 与掩码运算
		i = i & mask;
		System.out.println(Integer.toBinaryString(i));
	}

	static class BitOperation {
		//得到第i个bit是不是为1
		static boolean getBit(int num, int i) {
			return ((num & (1 << i)) != 0);
		}

		//将第i个bit设置为1,返回设置之后的结果。
		static int setBit(int num, int i) {
			return num | (1 << i);
		}

		//将第i个bit清零
		static int clearBit(int num, int i) {
			int mask = ~(1 << i);
			return num & mask;
		}

		// 先清零，再设置，就是更新。
		static int updateBit(int num, int i, int v) {
			int mask = ~(1 << i);
			return num & mask | (v << i);
		}
	}
	static class JavaBitSet{
		// JAVA类库中有一个@see BitSet 类。为一个按需增长的比特数组。
		//
	}
}

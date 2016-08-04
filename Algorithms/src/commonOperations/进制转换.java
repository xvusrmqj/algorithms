package commonOperations;

public class 进制转换 {
	public static void main(String[] args) {
		//	十进制转成十六进制：   
		Integer.toHexString(16);
		//	十进制转成八进制   
		Integer.toOctalString(8);
		//	十进制转成二进制   
		Integer.toBinaryString(2);
		//	十六进制转成十进制   
		Integer.parseInt("FFFF", 16);
		//	八进制转成十进制   
		Integer.parseInt("876", 8);
		//	二进制转十进制   
		Integer.parseInt("0101", 2);//最前面是负时不要写1，而是写负号。
	}
}

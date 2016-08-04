package java基础.数值表示;

/**
 * ***************************************************************
 * 【java的八种数据类型】
 * 
 * 1. 整型	所占空间
 *    byte:	    1
 *    short:	2
 *    int:		4
 *    long:	    8
 * 2. 实型      
 *    float:	4
 *    double:	8
 * 3. 其它      
 *    char:	    2	
 *    boolean:	x
 * 
 * 注1: C语言中使用1byte表示.
 * 注2: Java语言中32位64位数据类型所占空间一样,不需要sizeof()方法.
 * ***************************************************************
 * 【补码】
 * http://www.ruanyifeng.com/blog/2009/08/twos_complement.html
 * 原码为二进制、反码为各位取反，补码为反码+1
 * @author lv
 *
 */
public class 基本数据类型 {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = new String("abc");
		String s3 = new String(s1);
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s2.equals(s3));
	}
}

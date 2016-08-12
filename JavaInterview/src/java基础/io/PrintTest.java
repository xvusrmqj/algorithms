package java基础.io;
import org.junit.Test;

/**
 * 输出相关功能用例
 * 
 * @author lv
 *
 */
public class PrintTest {
	@Test
	/**
	 * 保留两位小数
	 */
	public void fun1(){
		float a = 1.456F;
		double b = 1.456;
		System.out.println(a);
		System.out.println(b);
		System.out.printf("%.2f\n", a);
		System.out.printf("%.2f\n", b);
	}
}

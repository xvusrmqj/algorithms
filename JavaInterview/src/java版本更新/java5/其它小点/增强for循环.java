package java版本更新.java5.其它小点;
/**
 * 数组及其它实现了Iterable接口的都能用.
 * @author lv
 *
 */
public class 增强for循环 {

	public static void main(String[] args) {
		for(String s : new String[]{"a","b","c","d"}){
			System.out.println(s);
		}
	}

}

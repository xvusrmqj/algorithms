package commonOperations;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * 正则表达式的使用
 * @author lv
 *
 */
public class RegexTest {
	//1. creating a regex is just new a String which conform to the regex rules.
	String regex1 = "abc";
	
	//2. use the regex.
	@Test
	/**
	 * String class have the following method can use regex directly.
	 * boolean matches(regex)
	 * String replaceAll(regex,replace)
	 * String replaceFirst(regex,replace)
	 * String[] split(regex)
	 */
	public void useInString(){
		String s = "hello, how are you?";
		String[] split = s.split(" ");
		for(String item : split){
			System.out.print(item+" | ");
		}
		System.out.println();
		//the same string , the first line return true , but the second return false;
		//Because the ? is not a general character , it is stand for zero or one time.
		System.out.println("123".matches("123")); //true
		System.out.println(s.matches("hello, how are you?"));//false
		System.out.println(s.matches("\\D*"));//true
		System.out.println(s.replaceFirst("h", "!"));
		System.out.println(s.replaceAll("h", "!"));
	}
	@Test
	/**
	 * use regex with the Matcher class and Pattern class.
	 * Pattern对象是正则表达式编译后在内存中的表示形式.
	 * 正则表达式字符串必须先被编译为Pattern对象, 然后再利用Pattern对象创建对应的Matcher对象.
	 * 执行匹配所涉及的状态保留在Matcher对象中,多个Matcher对象可以共享一个Pattern对象.
	 */
	public void useInPattern(){
		//1. 第一种方法Pattern可以复用
		Pattern pattern = Pattern.compile("\\w{3,20}@\\w+.(com|cn|org|net|gov)");
		Matcher m1 = pattern.matcher("www.baidu.com");
		Matcher m2 = pattern.matcher("olv@foxmail.com");
		Assert.assertFalse(m1.matches());
		Assert.assertTrue(m2.matches());
		//2. 如果不需要复用, 第二种方法更简单. 直接返回true|false. 如下.
		boolean m3 = Pattern.matches("0\\d{2}-\\d{8}|0\\d{4}-\\d{7}","010-61772000");
		Assert.assertTrue(m3);
		//3. 这样写也还好吧. 不是直接返回boolean, 而是返回Matcher
		Matcher m4 = Pattern.compile("(\\d{3}\\.){3}\\d{1,3}").matcher("255.255.255.1");
		Assert.assertTrue(m4.matches());
	}
	@Test
	public void testMatcherFun(){
		Matcher m4 = Pattern.compile("hi").matcher("hi hi 223 hi 123 hi");
		boolean matches = m4.matches();// 整个字符串是否匹配
		boolean lookingAt = m4.lookingAt();//整个字符串起始部分是否匹配
		boolean find = m4.find();//查找字符串中的多个匹配
		String group = m4.group();//返回前一个匹配组
		
		m4.reset();
		System.out.println(matches);//这时为假
		System.out.println(lookingAt);//这时为真
		System.out.println(find);//这时为真, 注意体会它和Matcher的不同.
		System.out.println(group);
		
		
	}
	
}

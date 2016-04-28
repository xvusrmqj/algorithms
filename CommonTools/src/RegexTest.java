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
	 * TODO later add. It is possible be used less in interview.
	 */
	public void useInMatcher(){
		
	}
	
}

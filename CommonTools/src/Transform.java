import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 转换相关用例
 * 1. string<-->charArray: new String(charArray), string.toCharArray.
 * 2. array<-->list: list.toArray(0 size array), Arrays.aslist(array not primitive)
 * 3. array-->string: Arrays.toString(intArr)//print the array is convient
 * @author lv
 *
 */
public class Transform {

	@Test
	public void string2charArray() {
		String s = "abcd";
		char[] charArray = s.toCharArray();
		for (char c : charArray) {
			System.out.println(c);
		}
	}

	@Test
	public void charArray2string() {
		char[] charArray = { 'a', 'b', 'c', 'd' };
		System.out.println(new String(charArray));
	}
	
	@Test
	public void list2array() {
		List<String> list = new ArrayList<>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		//this method return an object array.
		Object[] array = list.toArray();
		for(Object s : array){
			System.out.println(s);
		}
		System.out.println("-------------------");
		//this method return a special type array. the argument is an array which size is 0 generally. 
		String[] array2 = list.toArray(new String[0]);
		for(String s : array2){
			System.out.println(s);
		}
	}

	@Test
	public void array2list() {
		String[] stringArr = {"a","b","c"};
		List<String> asList = Arrays.asList(stringArr);
		for(String s:asList){
			System.out.println(s);
		}
		//this is an error. you can not use asList() to transform a primitive type.
//		int[] intArr = {1,2,3,4,5};
//		List<Integer> list = Arrays.asList(intArr);
//		for (Integer i : asList) {
//			System.out.println(i);
//		}
	}
	@Test
	public void array2string() {
		int[]  intArr = {1,2,3};
		String string = Arrays.toString(intArr);
		System.out.println(string);
	}
}

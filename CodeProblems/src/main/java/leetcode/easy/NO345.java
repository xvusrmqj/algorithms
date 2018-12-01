package leetcode.easy;

import org.junit.Test;

/**
 * 345. Reverse Vowels of a String
 * 
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 *	Example 1:
 *	Given s = "hello", return "holle".
 *
 *	Example 2:
 *	Given s = "leetcode", return "leotcede". 
 * 
 */
public class NO345 {

	@Test
	public void test() {
	}

	private boolean isVowels(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U') {
			return true;
		}
		return false;
	}

	public String reverseVowels(String s) {
		if (s == null || s.length() == 0)
			return "";

		char[] charArray = s.toCharArray();
		int i = 0;
		int j = charArray.length - 1;
		while (i < j) {
			// i find vowels
			if (!isVowels(charArray[i])) {
				i++;
			}
			// j find vowels
			if (!isVowels(charArray[j])) {
				j--;
			}
			// swap char[i] char[j]
			if (isVowels(charArray[i]) && isVowels(charArray[j])) {
				char tmp = charArray[i];
				charArray[i] = charArray[j];
				charArray[j] = tmp;
				i++;
				j--;
			}
		}
		return new String(charArray);
	}

}
/**
 * 总结：
 * 元音包括大小写，不要忘记大写。
*/

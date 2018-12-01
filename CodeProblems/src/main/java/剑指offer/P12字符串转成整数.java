package 剑指offer;

public class P12字符串转成整数 {

	public static void main(String[] args) {
		//		String s = "123";
		//		String s = "0123";
		String s = "-123";
		//		String s = "1c3";
		//		String s = "9999999999999999";
		System.out.println(transform2(s));
		//		String s = "0";

	}

	private static int transform1(String s) {
		int result = Integer.parseInt(s);
		return result;
	}

	private static int transform2(String s) {
		if (s == null || s.length() == 0) {
			throw new RuntimeException("input format wrong!");
		}
		int result = 0;
		boolean neg = s.charAt(0) == '-';
		int begin = neg ? 1 : 0;
		for (int i = begin; i < s.length(); i++) {
			result = result * 10 + (s.charAt(i) - '0');
		}
		if (neg)
			return -result;
		else
			return result;
	}

}

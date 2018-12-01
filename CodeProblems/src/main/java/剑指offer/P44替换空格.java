package 剑指offer;

public class P44替换空格 {

	public static void main(String[] args) {
//		String s = "abc";
//		String s = null;
//		String s = "a bc";
//		String s = "a\\r\\nbc";
		String[] arr = {"abc",null,"a bc","a\\r\\nbc"};
		for (int i = 0; i < arr.length; i++) {
			System.out.println(fun(arr[i]));
		}
	}
	public static String fun(String s) {
		if(s==null||s.length()==0) return s;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==' ') {
				sb.append("%20");
			}else{
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

}

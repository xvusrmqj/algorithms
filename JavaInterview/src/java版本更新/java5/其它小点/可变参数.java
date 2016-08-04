package java版本更新.java5.其它小点;

public class 可变参数 {
	public static void main(String[] args) {
		fun("abc"); //可传一个
		fun("123","456","789");//可传多个
		fun(new String[]{"hello","world"});//可传数组
	}
	public static void fun(String... varArgs){
		for(String s:varArgs){
			System.out.print(s+",");
		}
		System.out.println();
	}
}

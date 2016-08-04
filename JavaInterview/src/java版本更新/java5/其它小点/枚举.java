package java版本更新.java5.其它小点;

public class 枚举 {
	enum Season {
		spring, summer, fall, winter;//这四个不是Season的属性,是它的对象
	}
	public static void main(String[] args) {
		
		//1. 枚举的使用
		Season spring = Season.spring;
		//2. 枚举的遍历
		for(Season s : Season.values()){
			System.out.println(s);
		}
	}
	
}

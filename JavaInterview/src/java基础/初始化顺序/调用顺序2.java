package java基础.初始化顺序;

//这个打印什么?
// 1,5,2,3,6,8
public class 调用顺序2 {
	public static void main(String[] args) {
		new B("x");
	}

	static class A {
		static {
			System.out.println(1);
		}
		{
			System.out.println(2);
		}

		public A() {
			System.out.println(3);
		}

		public A(String s) {
			System.out.println(4);
		}
	}

	static class B extends A {
		static {
			System.out.println(5);
		}
		{
			System.out.println(6);
		}

		public B() {
			System.out.println(7);
		}

		public B(String s) {
			System.out.println(8);
		}
	}
}

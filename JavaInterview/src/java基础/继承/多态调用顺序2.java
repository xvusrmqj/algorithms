package java基础.继承;

//这个打印什么?
public class 多态调用顺序2 {
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

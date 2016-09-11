package java基础.初始化顺序;

//这个打印什么?
public class 多态调用顺序1 {
	public static void main(String[] args) {
		new B();
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
	}

	static class B extends A {
		static {
			System.out.println(4);
		}
		{
			System.out.println(5);
		}

		public B() {
			System.out.println(6);
		}
	}
}

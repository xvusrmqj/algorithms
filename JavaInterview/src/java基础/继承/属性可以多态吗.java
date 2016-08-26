package java基础.继承;

//这个打印什么?
public class 属性可以多态吗 {
	public static void main(String[] args) {
		A a = new B();
		System.out.println(a.i);
		B b = new B();
		System.out.println(b.i);
	}

	static class A {
		int i = 0;

		public A() {
			System.out.println(1);
		}

		public void fun() {
			System.out.println(2);
		}
	}

	static class B extends A {
		int i = 1;

		public B() {
			System.out.println(3);
		}

		public void fun() {
			System.out.println(4);
		}
	}
}

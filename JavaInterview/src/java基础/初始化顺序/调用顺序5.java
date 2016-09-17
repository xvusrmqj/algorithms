package java基础.初始化顺序;

//这个打印什么?
/*
*/
public class 调用顺序5 {
	static class C {
		C() {
			System.out.print("C");
		}
	}

	static class A {
		C c = new C();

		A() {
			this("A");
			System.out.print("A");
		}

		A(String s) {
			System.out.print(s);
		}
	}

	static class Test extends A {
		Test() {
			super("B");
			System.out.print("B");
		}

		public static void main(String[] args) {
			new Test();
		}
	}
}
/*
 * 调用父类构造器super()或者调用重载构造器this()必须在构造器里的第一行.
 * 从这里可以看出. 继承中先调用父类构造器再回到子类构造器,由这里规定保证的.
 * 
 * 而静态属性或代码块还没有进入构造方法所以和这个规定没有关系.
 */
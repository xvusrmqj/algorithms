package java基础.初始化顺序;

//这个打印什么?----------------------
/*Base---static
Child---static
begin--------
Base---
Base()---
Child----
Child()---
Base---
Base()---
Child----
Child()---
end--------*/
public class 调用顺序3 {

	static class Base {
		static {
			System.out.println("Base---static");
		}
		{
			System.out.println("Base---");
		}

		public Base() {
			System.out.println("Base()---");
		}
	}

	static class Child extends Base {
		static {
			System.out.println("Child---static");
		}
		{
			System.out.println("Child----");
		}

		public Child() {
			System.out.println("Child()---");
		}

		public static void main(String[] args) {
			System.out.println("begin--------");
			new Child();
			new Child();
			System.out.println("end--------");
		}
	}
}

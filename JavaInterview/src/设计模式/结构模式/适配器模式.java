package 设计模式.结构模式;

public class 适配器模式 {

	public static void main(String[] args) {
		适配器 adapter = new 适配器();
	}
//******************第一种适配器,使用继承*************************	
	interface 目标 {
		void 操作1();
		void 操作2();
	}

	static class 适配器 extends 源 implements 目标 {

		@Override
		public void 操作2() {

		}
	}

	static class 源 {
		public void 操作1() {

		}
	}
//********************第二种适配器,使用组合***********************	
	interface Target {
		void 操作1();
		void 操作2();
	}
	
	static class Adapter implements Target {
		Adaptee tee = new Adaptee();
		@Override
		public void 操作1() {
			tee.操作1();
		}
		@Override
		public void 操作2() {
			
		}

	}
	
	static class Adaptee {
		public void 操作1() {
			
		}
	}
}

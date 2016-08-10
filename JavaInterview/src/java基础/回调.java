package java基础;

/**
 * 1. 回调是一种双向调用模式，就是说，被调用方在被调用时也会调用对方，这就叫回调。
 * 2. 先登记,再调用也是一种回调. 见命令模式.
 * @author lv
 *
 */
public class 回调 {
	public static void main(String[] args) {
		//		new A().aFun(new B());
		//		new A2().a2Fun(new B2());
		new B3().b2Fun(new Callback() {
			@Override
			public void callback() {
				System.out.println("回调方法----");
			}
		});
	}

	static class A {
		public void aFun(B a) {
			a.bFun(this);
		}

		public void aFun2() {
			System.out.println("回调方法----");
		}
	}

	static class B {
		public void bFun(A b) {
			System.out.println("调用方法----");
			b.aFun2();
		}
	}

	//--------------第二种回调,用一个接口-----------------
	static class A2 implements Callback {
		public void a2Fun(B2 b) {
			b.b2Fun(this);

		}

		@Override
		public void callback() {
			System.out.println("回调方法----");
		}

	}

	interface Callback {
		void callback();
	}

	static class B2 {
		public void b2Fun(Callback c) {
			System.out.println("调用方法----");
			c.callback();
		}
	}

	//---------------第三种, 一般可能这样用-----------
	//直接来一个匿名内部类, 最方便了.
	static class B3 {
		public void b2Fun(Callback c) {
			System.out.println("调用方法----");
			c.callback();
		}
	}
}

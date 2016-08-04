package java基础;

/**
 * 1. 回调是一种双向调用模式，就是说，被调用方在被调用时也会调用对方，这就叫回调。
 * 2. 先登记,再调用也是一种回调. 见命令模式.
 * @author lv
 *
 */
public class 回调 {
	public static void main(String[] args) {
		new 厨师().做菜(new 小工());
	}

	static class 厨师 {
		public void 做菜(小工 a) {
			a.刷锅(this);
		}

		public void 做菜() {
			System.out.println("做菜完成----");
		}
	}

	static class 小工 {
		public void 刷锅(厨师 b) {
			System.out.println("刷锅完成----");
			b.做菜();
		}
	}
}

package java版本更新.java5.泛型;

public class Main {
	public static void main(String[] args) {
		MyList<String> mylist = new MyList<>(10);// 創建長度爲10的mylist
		mylist.add("abc");
		// mylist.add(new Fruit());这个不能添加

		MyList<? extends Fruit> mylist2 = new MyList<>(10);// mylist2中只能放Fruit的子类。
		MyList<Apple> mylist3 = new MyList<>(10);// mylist3中只能放Fruit类。
		mylist2 = mylist3;
		/*
		 * 因为编译器只知道fruits是Fruit的某个子类的List，但并不知道究竟是哪个子类，
		 * 为了类型安全，只好阻止向其中加入任何子类。那么可不可以加入Fruit呢？很遗憾，也不可以。
		 * 事实上，不能够往一个使用了? extends的数据结构里写入任何的值。
		 */
		//mylist2.add(new Apple());
		//但是，由于编译器知道它总是Fruit的子类型，因此我们总可以从中读取出Fruit对象：
		Fruit fruit = mylist2.get(0);
	}

	public static void foo(MyList<? extends Fruit> mylist) {
		Fruit f = mylist.get(1); // mylist 里的东西都是

		// mylist.add(?); // 编译通过么？ Why ?

	}
}
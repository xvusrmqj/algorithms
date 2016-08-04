package java版本更新.java5.泛型;

import java.util.List;
/*
 * 确定类型： 类型形参 T
 * 不确定类型：通配符形参 ？
 * 类型形参上限：T extends Type
 * 通配符形参上限：？ extends Type 
 * 通配符形参下限：？ super Type
 */
public class MyList<T> {
	private T[] arr;
	private int i = 0;

	// 泛型数组的初始化方法
	public MyList(int n) {
		arr = (T[]) new Object[n];
	}

	// 一般泛型的使用
	public void add(T t) {
		arr[i++] = t;
	}

	public T get(int i) {
		return arr[i--];
	}

	// 类型形参上限 & 方法泛型。
	public <E extends T> void addAll1(List<E> list) { // list集合里的东西只能是T的子类。
		for (T t : list) {
			add(t);
		}
	}

	// 通配符形参上限，等价于addAll1方法
	public void addAll2(List<? extends T> list) {
		for (T t : list) {
			add(t);
		}
	}

	// 通配符形参下限写法
	public void copyTo(List<? super T> list) { // list集合的的东西只能是T的父类。
		for (T t : arr) {
			list.add(t);
		}
	}
}
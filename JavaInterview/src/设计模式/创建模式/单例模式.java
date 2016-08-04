package 设计模式.创建模式;
/**
 * 1. 懒汉式
 * 		1.1 getInstance():线程不安全
 * 		1.2 synchronized getInstance():线程安全, 效率不高
 * 		1.3  双重加锁与volatile: 线程安全, 效率高
 * 		1.4  静态内部类: 线程安全, 效率高,不依赖于JDK版本
 * 2. 饿汉式: 线程安全, 因为类加载时就会初始化了.
 * 		2.1 private static Singleton instance = new Singleton();
 * 		2.1  枚举
 * 注：反射与反序列化可以破坏单例？？？怎么防止 ？
 * http://wuchong.me/blog/2014/08/28/how-to-correctly-write-singleton-pattern/
 * @author lv
 *
 */
public class 单例模式 {

	public static void main(String[] args) {

	}
	
}

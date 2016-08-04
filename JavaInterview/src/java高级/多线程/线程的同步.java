package java高级.多线程;

/**
 * 1. synchronized关键字(隐式加锁): 同步代码块与同步方法
 * 2. Lock对象(显式加锁)
 * 3. volatile关键字
 * 4. 原子变量
 * @author lv
 *
 */
public class 线程的同步  extends Thread {
	private int i = 0;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public static void main(String[] args) {
		new 线程的同步().start();
		new 线程的同步().start();

	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.currentThread().sleep(300);
				System.out.println(Thread.currentThread().getName()+": " +getI());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

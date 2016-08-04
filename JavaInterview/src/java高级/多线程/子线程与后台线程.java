package java高级.多线程;

/**
 * 1. 一般的线程是平行的,两者或不干扰
 * 2. 主线程杀后台线程: 后台线程依赖主线程.
 * 3. 主线程等子线程: 将事物分解,等子线程都执行完毕主线程再综合起来.
 * @author lv
 *
 */
public class 子线程与后台线程 {

	static int i = 0;

	public static void main(String[] args) throws InterruptedException {
		//1. 子线程 join方法
		//		subThread();
		//2. 后台线程setDaemon方法
		//		daemonThread();
		//3. 平行线程
		//		commonThread();
		//4.线程的常用方法
		Thread t = Thread.currentThread();//当前线程
		t.isAlive();//是否激活
		t.getName();
		t.getPriority();
		t.setPriority(Thread.MAX_PRIORITY);
		t.yield();
		
	}

	/**
	 * 普通的线程是平行执行的,两者互不干扰.
	 * 
	 */
	private static void commonThread() {
		new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 30; i++) {
					try {
						Thread.currentThread().sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("平行线程2: " + i);
				}
			}
		}.start();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.currentThread().sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("平行线程1: " + i);
		}
	}

	/**
	 * [[后台线程]]
	 * 
	 * 描述:
	 * 主线程执行了10次就死亡了, 后台线程执行30次才死亡,
	 * 但是主线程死亡了,后台线程也死亡了.执行不到30次
	 * @throws InterruptedException
	 */
	private static void daemonThread() throws InterruptedException {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					this.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//线程t1的执行体
				for (int i = 0; i < 30; i++) {
					try {
						Thread.currentThread().sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("后台线程: " + i);
				}
			}
		};
		t1.setDaemon(true);
		t1.start();
		for (int i = 0; i < 10; i++) {
			Thread.currentThread().sleep(300);
			System.out.println("主线程: " + i);
		}
	}

	/**
	 * [[子线程]]   join方法
	 * 描述：当小于800时，线程1和线程2都开始增加i的值,线程1增加100,线程2增加10.
	 * 当大于800时,线程1不再增加.
	 * 此时有三个线程.主线程和线程1,线程2. 使用join方法,让线程1和线程2都变成子线程.
	 * 主线程等待子线程完成之后再执行.
	 * @throws InterruptedException
	 */
	private static void subThread() throws InterruptedException {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					this.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//线程t1的执行体
				while (i < 800) {
					i += 100;
					System.out.println("hello1: " + i);
				}
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				try {
					this.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//线程t2的执行体
				while (i < 1000) {
					i += 10;
					System.out.println("hello2: " + i);
				}
			}
		};
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("Main Thread!");//主线程的执行体
	}

}

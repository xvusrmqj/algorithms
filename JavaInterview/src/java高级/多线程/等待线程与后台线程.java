package java高级.多线程;

/**
 * 1. 一般的线程是平行的,两者或不干扰
 * 2. 主线程杀后台线程: 后台线程依赖主线程.
 * 3. 主线程等子线程: 将事物分解,等子线程都执行完毕主线程再综合起来.
 * @author lv
 *
 */
public class 等待线程与后台线程 {

	static int i = 0;

	public static void main(String[] args) throws InterruptedException {
		//1. 子线程 join方法
//		joinThread();
		//2. 后台线程setDaemon方法
				daemonThread();
		//3. 平行线程
		//		commonThread();
		//4.线程的常用方法
		//		Thread t = Thread.currentThread();//当前线程
		//		t.isAlive();//是否激活
		//		t.getName();
		//		t.getPriority();
		//		t.setPriority(Thread.MAX_PRIORITY);
		//		Thread.yield();

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
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("平行线程2: " + i);
				}
			}
		}.start();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(300);
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
				for (int i = 0; i < 10; i++) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("后台线程: " + i);
				}
			}
		};
		t1.setDaemon(true);
		t1.start();
		for (int i = 0; i < 5; i++) {
			Thread.sleep(100);
			System.out.println("主线程: " + i);
		}
	}

	/**
	 * 等待线程: join方法
	 * 主线程等待线程t1完成之后再执行.
	 * @throws InterruptedException
	 */
	private static void joinThread() throws InterruptedException {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				while (i < 100) {
					i += 5;
					System.out.println("t1: " + i);
				}
			}
		};
		t1.start();
		t1.join();//主线程等待t1线程
		System.out.println("Main Thread!");//主线程的执行体
	}

}

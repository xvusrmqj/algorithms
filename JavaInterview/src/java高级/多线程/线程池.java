package java高级.多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 线程池 {
	static class myRunnable implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}
	}

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(6);
		pool.submit(new myRunnable());
		pool.submit(new myRunnable());
		pool.shutdown();
	}
}

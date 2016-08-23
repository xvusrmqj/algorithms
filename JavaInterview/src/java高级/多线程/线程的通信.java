package java高级.多线程;

import java.util.Stack;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.junit.Test;

// Synchronized: wait(),notify(),notifyAll()
// Lock: Condition await(),signal(),signalAll()
public class 线程的通信 {

	// 使用wait
	public static void testWait() throws InterruptedException {
		WaitTest waitTest = new WaitTest();
		new Thread() {
			public void run() {
				try {
					waitTest.消费();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();
		new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				waitTest.生产();
			};
		}.start();
	}

	public static void main(String[] args) throws InterruptedException {
//		testWait();
		testCondition();
	}

	// 使用条件变量
	public static void testCondition() {
		LockTest lockTest = new LockTest();
		new Thread() {
			public void run() {
				try {
					lockTest.消费();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();
		new Thread() {
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				lockTest.生产();
			};
		}.start();
	}

	// 使用管道
	public void testPipe() {

	}

	static class LockTest {
		Stack<Integer> stack = new Stack<>();
		private final Lock lock = new ReentrantLock();
		private final Condition cdn = lock.newCondition();

		public void 生产() {
			lock.lock();
			System.out.println("生产...");
			stack.push(1);
			cdn.signalAll();
			lock.unlock();
		}

		public void 消费() throws InterruptedException {
			lock.lock();
			if (stack.isEmpty()) {
				System.out.println("等待前...");
				cdn.await();
				System.out.println("等待后...");
			}
			stack.pop();
			System.out.println("消费中...");
			lock.unlock();
		}
	}

	static class WaitTest {
		Stack<Integer> stack = new Stack<>();

		public synchronized void 生产() {
			System.out.println("生产...");
			stack.push(1);
			notifyAll();
		}

		public synchronized void 消费() throws InterruptedException {
			if (stack.isEmpty()) {
				System.out.println("等待前...");
				wait();
				System.out.println("等待后...");
			}
			stack.pop();
			System.out.println("消费中...");
		}
	}
}

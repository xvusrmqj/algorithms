package 数据结构;

import org.junit.Test;

public class 循环队列 {
	int[] arr = null;

	public 循环队列(int[] arr) {
		this.arr = arr;
	}

	public void 遍历(int start) throws InterruptedException {
		int i = start;
		System.out.print(arr[i]);
		while (true) {
			
			int next = ++i % arr.length;
			if (next == start)
				break;
			System.out.print(arr[next]);
		}
	}

	public static void main(String[] args) {
		try {
			new 循环队列(new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }).遍历(5);
		} catch (Exception e) {
			System.out.println("22===");
		}
	}

	@Test
	public void test() {
		try {
			System.out.println("-------------");
			//			new 循环队列(new int[]{0,1,2,3,4,5,6,7}).遍历(5);
		} catch (Exception e) {
			System.out.println("22===");
		}
	}/*
		TODO: 这是什么鬼. 为什么JUnit在这里报错????
		java.lang.Exception: No tests found matching [{ExactMatcher:fDisplayName=test], {ExactMatcher:fDisplayName=test(数据结构.循环队列)], {LeadingIdentifierMatcher:fClassName=数据结构.循环队列,fLeadingIdentifier=test]] from org.junit.internal.requests.ClassRequest@7a07c5b4
		at org.junit.internal.requests.FilterRequest.getRunner(FilterRequest.java:40)
		at org.eclipse.jdt.internal.junit4.runner.JUnit4TestLoader.createFilteredTest(JUnit4TestLoader.java:77)
		at org.eclipse.jdt.internal.junit4.runner.JUnit4TestLoader.createTest(JUnit4TestLoader.java:68)
		at org.eclipse.jdt.internal.junit4.runner.JUnit4TestLoader.loadTests(JUnit4TestLoader.java:43)
		at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:444)
		at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:675)
		at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:382)
		at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:192)
		*/
}

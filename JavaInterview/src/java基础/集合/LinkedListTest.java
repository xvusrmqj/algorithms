package java基础.集合;

import java.util.LinkedList;

//LinkedList可用做栈, 队列, 双端队列
public class LinkedListTest {
	//	public static void main(String[] args) {
	//		Queue<Integer> queue = new Queue<>();
	//		queue.enQueue(1);
	//		queue.enQueue(2);
	//		queue.enQueue(3);
	//		queue.enQueue(4);
	//		queue.enQueue(5);
	//		queue.deQueue();
	//		while(!queue.isempty()){
	//			System.out.println(queue.deQueue());
	//		}
	//	}
//	public static void main(String[] args) {
//		Stack<Integer> stack = new Stack<>();
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		stack.push(4);
//		stack.push(5);
//		while (!stack.isempty()) {
//			System.out.println(stack.pop());
//		}
//	}
	public static void main(String[] args) {
		DeQueue<Integer> dequeue = new DeQueue<>();
		dequeue.addFirst(3);
		dequeue.addFirst(2);
		dequeue.addFirst(1);
		dequeue.addLast(4);
		dequeue.addLast(5);
		dequeue.addLast(6);
		while (!dequeue.isempty()) {
			System.out.println(dequeue.removeFirst());
		}
	}

	static class DeQueue<T> {
		private LinkedList<T> list = new LinkedList<>();

		public void addFirst(T t) {
			list.addFirst(t);
		}

		public void addLast(T t) {
			list.addLast(t);
		}

		public T removeFirst() {
			return list.removeFirst();
		}

		public T removeLast() {
			return list.removeLast();
		}

		public boolean isempty() {
			return list.isEmpty();
		}
	}

	static class Stack<T> {
		private LinkedList<T> list = new LinkedList<>();

		public void push(T t) {
			list.push(t);
		}

		public T pop() {
			return list.pop();
		}

		public boolean isempty() {
			return list.isEmpty();
		}

	}

	static class Queue<T> {
		private LinkedList<T> list = new LinkedList<>();

		public void enQueue(T t) {
			list.add(t);
		}

		public T deQueue() {
			return list.remove();
		}

		public boolean isempty() {
			return list.isEmpty();
		}
	}
}

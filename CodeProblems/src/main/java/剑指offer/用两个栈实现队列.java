package 剑指offer;

import java.util.Stack;

/**
 * 
 * 
 * @author lv
 *
 */
public class 用两个栈实现队列 {


	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();

	public static void push(int node) {
		stack1.push(node);
	}

	public static int pop() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();

	}

}

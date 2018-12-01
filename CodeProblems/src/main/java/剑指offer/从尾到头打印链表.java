package 剑指offer;

import java.util.ArrayList;
import java.util.Stack;

import tools.ListNode;

/**
 * 
 * 
 * @author lv
 *
 */
public class 从尾到头打印链表 {

	public static void main(String[] args) {
		int[] arr = {};
		for (int i = 0; i < arr.length; i++) {
		}
	}
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    	Stack<Integer> stack = new Stack<>();
    	ArrayList<Integer> list = new ArrayList<>();
    	while(listNode!=null){
    		stack.push(listNode.val);
    		listNode = listNode.next;
    	}
    	while(!stack.isEmpty()){
    		list.add(stack.pop());
    	}
        return list;
    }
}

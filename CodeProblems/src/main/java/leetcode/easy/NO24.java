package leetcode.easy;

import org.junit.Test;

import tools.ListNode;

/**
 * 24. Swap Nodes in Pairs
 *  Given a linked list, swap every two adjacent nodes and return its head.

 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.

 * Your algorithm should use only constant space. You may not modify the values 
 * in the list, only nodes itself can be changed. 
 * 
 */
public class NO24 {

	@Test
	public void test() {
		//Input:[1,2],Expected:[2,1]
		ListNode listNode1 = new ListNode(1);
		ListNode listNode2 = new ListNode(2);
		listNode1.next=listNode2;
		ListNode swapPairs = swapPairs(listNode1);
		ListNode.printList(swapPairs);
	}
	
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode newHead=head.next;
		ListNode tmp ;
		ListNode tail = null;
		while(head!=null&&head.next!= null){
			tmp = head.next;
			head.next = head.next.next;
			tmp.next = head;
			if(tail!=null){
				tail.next = tmp;
			}
			tail = head;
			head = head.next;
		}
		return newHead;
	}

}
/**
 * 总结：
 * 题目中不让改变节点的值，所以tmp=a; a=b; b=tmp;这种方式用不上。
 * 其实如果没有要求的话，节点的交换用换值的方式可能更方便一点。
 * 
 * 做这种题目就是一点一点画出来，一步一步画出来就好了。注意 一下初始情况。
*/

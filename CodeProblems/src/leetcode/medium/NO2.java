package leetcode.medium;

import org.junit.Test;

import tools.ListNode;

/**
 * 2. Add Two Numbers
 * 
 * You are given two linked lists representing two non-negative numbers. The
 * digits are stored in reverse order and each of their nodes contain a single
 * digit. Add the two numbers and return it as a linked list.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 */
public class NO2 {
	@Test
	public void test() {
		ListNode a = ListNode.initListByArray(new int[] {2,4,3});
		ListNode b = ListNode.initListByArray(new int[] { 5,6,4});
		ListNode numbers = addTwoNumbers(a, b);
		ListNode.printList(numbers);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode point = head;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int first = 0;
			int second = 0;
			int val = 0;
			if (l1 != null) {
				first = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				second = l2.val;
				l2 = l2.next;
			}

			val = (first + second + carry) % 10;
			ListNode node = new ListNode(val);
			point.next = node;
			point = point.next;
			if ((first + second + carry) >= 10) {
				carry = 1;
			} else {
				carry = 0;
			}
		}
		if (carry == 1) {
			ListNode node = new ListNode(1);
			point.next = node;
			point = point.next;
		}
		point.next = null;
		return head.next;
	}

}

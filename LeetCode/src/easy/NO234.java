package easy;

import static org.junit.Assert.*;

import org.junit.Test;

import tools.ListNode;

/**
 * 234. Palindrome Linked List
 * 
 * Given a singly linked list, determine if it is a palindrome. Follow up: Could
 * you do it in O(n) time and O(1) space?
 */
public class NO234 {
	@Test
	public void test() {
		ListNode list = new ListNode(1);
		ListNode n = new ListNode(2);
		list.next = n;
		boolean palindrome = isPalindrome(list);
		System.out.println(palindrome);
	}

	public boolean isPalindrome(ListNode head) {
		if (head == null)
			return true;

		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		//reverse list 反转单链表还是不能一次写成功。
		ListNode reverse1 = ListNode.reverse1(slow);
		

		for (; reverse1 != null && head != null; reverse1 = reverse1.next, head = head.next) {
			if (reverse1.val != head.val)
				return false;
		}
		return true;
	}
}

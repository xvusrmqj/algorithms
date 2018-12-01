package leetcode.hard;

import org.junit.Test;

import tools.ListNode;

/*
 * 148. Sort List
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 */
public class NO148 {
	@Test
	public void test() {
		ListNode a = ListNode.initListByArray(new int[] { 2 });
		ListNode b = ListNode.initListByArray(new int[] { 2, 4, 6, 8, 10 });
		ListNode a1 = findMedium(a);
		ListNode b1 = findMedium(b);
		System.out.println(a1.val);
		System.out.println(b1.val);
	}

	//TODO 归并链表。
	public ListNode sortList(ListNode head) {
		ListNode medium = findMedium(head);
		if (head == medium)
			return head;
		if (head.next == medium)
			return merge(head, medium);
		else {

		}
		return null;
	}

	private ListNode findMedium(ListNode list) {
		if (list == null)
			return null;
		ListNode fast = list;
		ListNode slow = list;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private ListNode merge(ListNode a, ListNode b) {

		ListNode head = new ListNode(0);
		ListNode point = head;
		while (a != null && b != null) {
			if (a.val < b.val) {
				point.next = a;
				a = a.next;
			} else {
				point.next = b;
				b = b.next;
			}
			point = point.next;
		}
		if (a == null)
			point.next = b;
		if (b == null) {
			point.next = a;
		}
		return head.next;
	}
}

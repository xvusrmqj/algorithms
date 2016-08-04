package hard;

import org.junit.Test;

import tools.ListNode;

/*
 * 147. Insertion Sort List
 * Sort a linked list using insertion sort.
 * TODO 为什么思路正确就是写不出代码？？？？
 */
public class NO147 {
	@Test
	public void test() {
		ListNode a = ListNode.initListByArray(new int[] { 5, 4, 3, 2, 1 });
		ListNode b = ListNode.initListByArray(new int[] { 2, 4, 6, 8, 10 });
		ListNode c = ListNode.initListByArray(new int[] { 1, 5, 3, 6, 2 });
		ListNode d = ListNode.initListByArray(new int[] { 1,5 });
		ListNode e = ListNode.initListByArray(new int[] {});

		//		ListNode list1 = insertionSortList(a);
		//		ListNode list2 = insertionSortList(b);
		//		ListNode list3 = insertionSortList(c);
		//		ListNode list4 = insertionSortList(d);
		//		ListNode list5 = insertionSortList(e);
		//		ListNode.printList(list1);
		//		ListNode.printList(list2);
		//		ListNode.printList(list3);
		//		ListNode.printList(list4);
		//		ListNode.printList(list5);
	}

	public ListNode insertionSortList(ListNode first) {
		return null;
	}

	// insert with head node 
	private void insert(ListNode p, ListNode insertPoint) {

	}

	// find with head node
	private ListNode findInserPoint(ListNode p, ListNode begin, ListNode end) {
		return null;
	}
}

package tools;


public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public static void printList(ListNode list) {
		while (list != null) {
			System.out.print(list.val + "->");
			list = list.next;
		}
		System.out.println("null");
	}
}

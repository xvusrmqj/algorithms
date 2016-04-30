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

	public static ListNode initListByArray(int[] arr) {
		// 对于不要头结点的链接，比较好的方法就是先加再删除。
		ListNode head = new ListNode(-1);
		ListNode tail = head;

		for (int i = 0; i < arr.length; i++) {
			ListNode node = new ListNode(arr[i]);
			tail.next = node;
			tail = tail.next;
		}
		// 删除头结点
		return head.next;
	}

	// 这么简单也弄了好久，我始终不知道怎么改变。应该就是一个条件的事啊？但是这个条件怎么设？
	// 原来就是在里边设一下就行，而不是在while条件里。
	public static ListNode reverse(ListNode head) {
		ListNode pointTo = null;
		ListNode pointFrom = head;
		while (head != null) {
			System.out.print("--->");
			printList(pointFrom);
			head = head.next;
			pointFrom.next = pointTo;
			pointTo = pointFrom;
			if (head != null)
				pointFrom = head;

		}
		return pointFrom;
	}

	// 使用头插法应该就可以。
	public static ListNode reverse1(ListNode head) {
		if (head == null)
			return null;
		// 先初始化一个头结点
		ListNode newHead = new ListNode(-1);
		ListNode current = head;
		ListNode next;
		while (current != null) {
			next = current.next;
			current.next = newHead.next;
			newHead.next = current;
			current = next;
		}
		// 再删除这个头结点
		return newHead.next;
	}

	// 测试initListByArray和printList方法。
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		ListNode initListByArray = initListByArray(arr);
		printList(initListByArray);

		ListNode reverse = reverse(initListByArray);
		printList(reverse);

	}
}

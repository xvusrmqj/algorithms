package tools;

/**
 * 不带泛型的ListNode，带泛型的请使用{@link ListNode1}
 * 
 * @author lv
 *
 * @param
 */
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
		if (arr == null || arr.length == 0)
			return null;
		// 对于不要头结点的链接，比较好的方法就是先加再删除。
		ListNode head = new ListNode(arr[0]);
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

	// 头插法
	public static ListNode reverse1(ListNode list) {
		if (list == null)
			return null;
		ListNode newList = new ListNode(list.val);// 先初始化一个头结点
		ListNode tmp = null; //防止链表断开。
		while (list != null) {
			tmp = list.next; //先临时存起来
			list.next = newList.next;
			newList.next = list;
			list = tmp; //最后再取出来
		}
		return newList.next;// 再删除这个头结点
	}

	// 头插法反转单链表，但是不改变原链表结构。
	public static ListNode reverseCopy(ListNode list) {
		if (list == null)
			return null;
		ListNode newList = new ListNode(list.val);// 先初始化一个头结点
		while (list != null) {
			ListNode node = new ListNode(list.val);
			node.next = newList.next;
			newList.next = node;

			list = list.next;
		}
		return newList.next;// 再删除这个头结点
	}

	// 测试initListByArray和printList方法。
	public static void main(String[] args) {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[] arr2 = { 1 };
		int[] arr3 = {};
		ListNode initListByArray = initListByArray(arr1);
		printList(initListByArray);

		ListNode reverse = reverseCopy(initListByArray);
		printList(reverse);
		printList(initListByArray);
	}
}
/**
 * 总结：对于链表的题目。 1. 首先要列出限制条件。 2. 然后要划出来一步一步的操作。 3.
 * 最后要思考用多少个变量（1个够吗？2个够吗？...）这些变量的作用是什么？ 并要找到这些变量的限制条件，从何开始，到何结束。 注：
 * 23步想到多的限制条件，更新1表。
 */

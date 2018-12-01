package tools;
/**
 * 带泛型的ListNode，不带泛型的请使用{@link ListNode}
 * @author lv
 *
 * @param <Item>
 */
public class ListNode1<Item> {
	public Item val;
	public ListNode1<Item> next;

	public ListNode1(Item x) {
		val = x;
	}

	public static <Item> void printList(ListNode1<Item> list) {
		while (list != null) {
			System.out.print(list.val + "->");
			list = list.next;
		}
		System.out.println("null");
	}
	//静态方法使用泛型只能使用泛型方法。使用泛型类不能通过编译。
	public static <Item> ListNode1<Item> initListByArray(Item[] arr) {
		if(arr==null || arr.length ==0) return null;
		// 对于不要头结点的链接，比较好的方法就是先加再删除。
		ListNode1<Item> head = new ListNode1<Item>(arr[0]);
		ListNode1<Item> tail = head;

		for (int i = 0; i < arr.length; i++) {
			ListNode1<Item> node = new ListNode1<Item>(arr[i]);
			tail.next = node;
			tail = tail.next;
		}
		// 删除头结点
		return head.next;
	}

	// 这么简单也弄了好久，我始终不知道怎么改变。应该就是一个条件的事啊？但是这个条件怎么设？
	// 原来就是在里边设一下就行，而不是在while条件里。
	public static <Item> ListNode1<Item> reverse(ListNode1<Item> head) {
		ListNode1<Item> pointTo = null;
		ListNode1<Item> pointFrom = head;
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
	public static <Item> ListNode1<Item> reverse1(ListNode1<Item> list) {
		if(list == null) return null;
		ListNode1<Item> newList = new ListNode1<Item>(list.val);// 先初始化一个头结点
		ListNode1<Item> tmp = null; //防止链表断开。
		while (list != null) {
			tmp = list.next; //先临时存起来
			list.next = newList.next;
			newList.next = list;
			list = tmp; //最后再取出来
		}
		return newList.next;// 再删除这个头结点
	}

	// 头插法反转单链表，但是不改变原链表结构。
	public static <Item> ListNode1<Item> reverseCopy(ListNode1<Item> list) {
		if(list == null) return null;
		ListNode1<Item> newList = new ListNode1<Item>(list.val);// 先初始化一个头结点
		while (list != null) {
			ListNode1<Item> node = new ListNode1<Item>(list.val);
			node.next = newList.next;
			newList.next = node;

			list = list.next;
		}
		return newList.next;// 再删除这个头结点
	}

	// 测试initListByArray和printList方法。
	public static void main(String[] args) {
		Integer[] arr1 = { 1, 2, 3, 4, 5 };
		Integer[] arr2 = { 1 };
		Integer[] arr3 = {};
		ListNode1<Integer> initListByArray = initListByArray(arr1);
		printList(initListByArray);

		ListNode1<Integer> reverse = reverseCopy(initListByArray);
		printList(reverse);
		printList(initListByArray);
	}
}
/**
 * 总结：对于链表的题目。 1. 首先要列出限制条件。 2. 然后要划出来一步一步的操作。 3.
 * 最后要思考用多少个变量（1个够吗？2个够吗？...）这些变量的作用是什么？ 并要找到这些变量的限制条件，从何开始，到何结束。 注：
 * 23步想到多的限制条件，更新1表。
 */

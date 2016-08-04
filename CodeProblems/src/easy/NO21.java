package easy;

import org.junit.Test;

import tools.ListNode;

/**
 * 21. Merge Two Sorted Lists 
 * 
 * Merge two sorted linked lists and return it as a new list. The new list 
 * should be made by splicing together the nodes of the first two lists.
 * 
 */
public class NO21 {

	@Test
	public void test() {
		//input : [2] [1] 
		//expected: [1,2]
		ListNode list1 = new ListNode(2);
		ListNode list2= new ListNode(1);
		ListNode list3 = mergeTwoLists(list1, list2);
		ListNode.printList(list3);
	}


	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

		//先弄一个头结点，最后再删除。
		ListNode listNode = new ListNode(0);
		ListNode point = listNode;
		// 找小的，加入新单链表后右移指针
		while(l1!=null&&l2!=null){
			
			if(l1.val<l2.val){
				point.next = l1;
				l1=l1.next;
			}else{
				point.next = l2;
				l2=l2.next;
			}
			point=point.next; 
		}
		if(l1!=null){
			point.next = l1;
		}
		if(l2!=null){
			point.next = l2;
		}
		
		//删除头结点:这样可以吗？会不会头结点不被垃圾回收？
		return listNode.next;
	}
	
}
/**
 * 总结：
 * 咋一下，这个不就是考归并排序吗？归并排序是排无序的，
 * 这个是排有序的。这个题其实做过很多遍，但是还是不能
 * 一次完成。这次的错误在于listNode是一个头结点不能后
*/








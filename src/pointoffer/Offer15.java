package pointoffer;

import pointoffer.referenceclass.ListNode;

public class Offer15 {
	public ListNode ReverseList(ListNode head) {
		if(head==null) {
			return head;
		}
		ListNode node = head.next;
		head.next = null;
		while(node!=null) {
			ListNode temp = node.next;
			node.next = head;
			head = node;
			node = temp;
		}
		return head;
    }
}
/*
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
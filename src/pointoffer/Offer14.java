package pointoffer;

import pointoffer.referenceclass.ListNode;

public class Offer14 {
	public ListNode FindKthToTail(ListNode head,int k) {
		ListNode aNode = head;
		for(int i = 0;i < k;i++) {
			if(head==null) {
				return null;
			}
			head = head.next;
		}
		while(head!=null) {
			aNode= aNode.next;
			head = head.next;
		}
		return aNode;
    }
}
/*
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
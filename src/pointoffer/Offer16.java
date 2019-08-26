package pointoffer;

import pointoffer.referenceclass.ListNode;

public class Offer16 {
	public ListNode Merge(ListNode list1,ListNode list2) {
		if(list1==null) {
			return list2;
		}
		if(list2==null) {
			return list1;
		}
		
        ListNode head = list1.val<=list2.val?list1:list2;
        ListNode add = list1.val>list2.val?list1:list2;
        while(add!=null) {
        	if(head.next==null) {
        		head.next = add;
        		break;
        	}
        	if(add.val<head.next.val) {
        		ListNode temp = head.next;
        		head.next = add;
        		add = temp;
        	}
        	head = head.next;
        }
        return list1.val<=list2.val?list1:list2;
    }
}
/*
 * 题目描述 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
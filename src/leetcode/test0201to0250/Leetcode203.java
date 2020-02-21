package leetcode.test0201to0250;

import leetcode.referenceclass.ListNode;

public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
    	while(head!=null&&head.val==val) {
    		head = head.next;
    	}
    	
    	ListNode temp = head;
    	while(temp!=null) {
    		if(temp.next!=null&&temp.next.val==val) {
    			temp.next = temp.next.next;
    		}else {
    			temp = temp.next;
    		}
    	}
    	return head;
    }
}
/*
	
	删除链表中等于给定值 val 的所有节点。
	
	示例:
	
	输入: 1->2->6->3->4->5->6, val = 6
	输出: 1->2->3->4->5
*/
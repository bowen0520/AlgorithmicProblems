package leetcode.test0001to0050;

import leetcode.referenceclass.ListNode;

public class Leetcode21 {
	public static void main(String[] args) {
		
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
        ListNode head = null;
        ListNode tail = null;
        
        if(l1.val<=l2.val) {
    		head = l1;
    		tail = l1;
    		l1 = l1.next;
    	}else {
    		head = l2;
    		tail = l2;
    		l2 = l2.next;
    	}
        
        while(l1!=null&&l2!=null) {
        	if(l1.val<=l2.val) {
        		tail.next = l1;
        		l1 = l1.next;
        		tail = tail.next;
        	}else {
        		tail.next = l2;
        		l2 = l2.next;
        		tail = tail.next;
        	}
        }
        if(l1!=null) {
        	tail.next = l1;
        }
        if(l2!=null) {
        	tail.next = l2;
        }
        return head;
    }
	
}
/*
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
*/

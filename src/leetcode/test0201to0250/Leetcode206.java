package leetcode.test0201to0250;

import leetcode.referenceclass.ListNode;

public class Leetcode206 {
	/*public ListNode reverseList(ListNode head) {
		if(head==null){
	        return head;
	    }
	    ListNode temp = head;
	    while(temp.next!=null) {
	    	ListNode node = temp.next;
	    	temp.next = node.next;
	    	node.next = head;
	    	head = node; 
	    }
	    return head;
	}*/
    
    public ListNode reverseList(ListNode head) {
        return reverseList(head, head);
    }
    
    public ListNode reverseList(ListNode head,ListNode temp) {
    	if(temp==null||temp.next==null){
            return head;
        }

		ListNode node = temp.next;
		temp.next = node.next;
		node.next = head;
		head = node;

        return reverseList(head, temp);
    }
    
}
/*
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
*/
package leetcode.test0001to0050;

import leetcode.referenceclass.ListNode;

public class Leetcode2 {
    public ListNode  addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null) {
    		return  l2;
    	}
    	if(l2 == null) {
    		return l1;
    	}
    	ListNode head = l1;
    	ListNode tail = l1;
        int temp = 0;
        while(l1 != null && l2 != null) {
        	int num = l1.val+l2.val+temp;
        	l1.val = num%10;
        	temp = num/10;
        	tail = l1;
        	l1 = l1.next;
        	l2 = l2.next;
        	
        }
        
        if(l1 != null) {
        	while(l1 != null&&temp!=0) {
        		int num = l1.val + temp;
        		l1.val = num % 10;
        		temp = num/10;
        		tail = l1;
        		l1 = l1.next;
        	}
        }else {
        	tail.next = l2;
        	while(l2 != null&&temp!=0) {
        		int num = l2.val + temp;
        		l2.val = num % 10;
        		temp = num/10;
        		tail = l2;
        		l2 = l2.next;
        	}
        }
        if(temp != 0) {
        	tail.next = new ListNode(temp);
        }
        return head;
    }
}
/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
*/

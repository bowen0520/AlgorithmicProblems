package leetcode.test0201to0250;

import leetcode.referenceclass.ListNode;

public class Leetcode234 {
	public static void main(String[] args) {
		ListNode one = new ListNode(1);
		ListNode two = new ListNode(2);
		ListNode three = new ListNode(2);
		ListNode four = new ListNode(2);
		ListNode five = new ListNode(1);
		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;
		System.out.println(isPalindrome(one));
	}
    public static boolean isPalindrome(ListNode head) {
    	if(head==null||head.next==null) {
    		return true;
    	}
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null&&fast.next.next!=null) {
        	fast = fast.next.next;
        	ListNode temp = slow.next;
        	slow.next = slow.next.next;
        	temp.next = head;
        	head = temp;
        }
        boolean flag = fast.next == null;
        fast = head;
        while(slow.next!=null) {
        	if(flag) {
        		if(fast.next.val!=slow.next.val) {
        			return false;
        		}else {
        			fast = fast.next;
        			slow = slow.next;
        		}
        	}else {
        		if(fast.val!=slow.next.val) {
        			return false;
        		}else {
        			fast = fast.next;
        			slow = slow.next;
        		}
        	}
        }
        return true;
    }
}
/*
请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:


输入: 1->2->2->1
输出: true
*/
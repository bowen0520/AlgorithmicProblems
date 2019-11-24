package leetcode.test001to050;

import leetcode.referenceclass.ListNode;

public class Leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode start  = head;
        ListNode end = head;
        for(int i = 0;i<=n;i++) {
        	if(end==null) {
        		return head.next;
        	}
        	end = end.next;
        }
        
        while(end!=null) {
        	start = start.next;
        	end = end.next;
        }
        
        start.next = start.next.next;
        
        return head;
    }
}
/*
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
说明：

给定的 n 保证是有效的。

进阶：

你能尝试使用一趟扫描实现吗？
*/
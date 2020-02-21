package leetcode.test0051to0100;

import java.util.HashSet;

import leetcode.referenceclass.ListNode;

public class Leetcode61 {
	public static void main(String[] args) {
		HashSet<Integer> hash = null;
	}
    public ListNode rotateRight(ListNode head, int k) {
    	if(head==null){
            return head;
        }
        int len = 0;
        ListNode node = head;
        while(node != null) {
        	len++;
        	node = node.next;
        }
        
        int step = k % len;
        if(step==0) {
        	return head;
        }
        ListNode tail = head;
        node = head;
        while(tail.next != null) {
        	if(step<=0) {
        		node = node.next;
        	}
        	tail = tail.next;
        	step--;
        }
        tail.next = head;
        head = node.next;
        node.next = null;
        return head;
    }
}
/*
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: 1->2->3->4->5->NULL, k = 2
输出: 4->5->1->2->3->NULL
解释:
向右旋转 1 步: 5->1->2->3->4->NULL
向右旋转 2 步: 4->5->1->2->3->NULL
示例 2:

输入: 0->1->2->NULL, k = 4
输出: 2->0->1->NULL
解释:
向右旋转 1 步: 2->0->1->NULL
向右旋转 2 步: 1->2->0->NULL
向右旋转 3 步: 0->1->2->NULL
向右旋转 4 步: 2->0->1->NULL
*/

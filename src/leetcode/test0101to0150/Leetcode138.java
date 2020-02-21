package leetcode.test0101to0150;

import leetcode.referenceclass.Node3;

public class Leetcode138 {
	public Node3 copyRandomList(Node3 head) {
		Node3 node = head;
        while(node!=null) {
        	Node3 temp = new Node3();
        	temp.val = node.val;
        	temp.next = node.next;
        	node.next = temp;
        	node = node.next.next;
        }
        
        node = head;
        while(node != null) {
        	if(node.random != null) {
        		node.next.random = node.random.next;
        	}
        	node = node.next.next;
        }
        
        Node3 h = head.next;
        node = h;
        while(node != null&&node.next != null) {
        	node.next = node.next.next;
        	node = node.next;
        }
        return h;
    }
}
/*
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的深拷贝。 

示例：

输入：
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

解释：
节点 1 的值是 1，它的下一个指针和随机指针都指向节点 2 。
节点 2 的值是 2，它的下一个指针指向 null，随机指针指向它自己。
*/

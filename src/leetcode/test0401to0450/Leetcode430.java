package leetcode.test0401to0450;

import leetcode.referenceclass.Node2;

public class Leetcode430 {
    public Node2 flatten(Node2 head) {
    	
    	Node2 temp = head;
        while(temp != null) {
        	if(temp.child != null) {
        		Node2 node= flatten(temp.child);
        		Node2 next = temp.next;
        		temp.next = node;
        		node.prev = temp;
        		temp.child = null;
        		while(node.next!=null) {
        			node = node.next;
        		}
        		node.next = next;
        		if(next!=null) {
        			next.prev = node;
        		}
        		temp = node;
        	}
        	temp = temp.next;
        }
        return head;
    }
    
    public Node2 flatten1(Node2 head) {
    	help1(head);
        return head;
    }
    
    public Node2 help1(Node2 head) {
    	
    	Node2 temp = head;
        while(temp != null) {
        	if(temp.child != null) {
        		Node2 tail= help1(temp.child);
        		Node2 next = temp.next;
        		temp.next = temp.child;
        		temp.child.prev = temp;
        		temp.child = null;
        		if(next!=null) {
        			tail.next = next;
        			next.prev = tail;
        		}
        		temp = tail;
        	}
        	if(temp.next==null) {
        		break;
        	}
        	temp = temp.next;
        }
        return temp;
    }
    Node2 prev = null;
    
    public Node2 flatten2(Node2 head) {
    	help(head);
        return head;
    }
    
    public void help(Node2 head) {
    	if(head == null) {
    		return;
    	}
    	Node2 node = head.next;
    	
    	if(prev != null) {
    		prev.next = head;
    		head.prev = prev;
    	}
    	prev = head;
    	help(head.child);
    	head.child=null;
    	help(node);	
    }
}
/*
您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。

扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。

 

示例:

输入:
 1---2---3---4---5---6--NULL
         |
         7---8---9---10--NULL
             |
             11--12--NULL

输出:
1-2-3-7-8-11-12-9-10-4-5-6-NULL
*/
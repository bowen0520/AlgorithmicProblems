package leetcode.test0701to0750;

public class Leetcode707 {

}
class MyLinkedList2 {
	
	class Node{
		int val;
		Node next;
		Node prev;
		
		public Node(int val) {
			this.val = val;
		}
	}
	int len;
	Node head;
	Node end;

    /** Initialize your data structure here. */
    public MyLinkedList2() {
        head = new Node(0);
        end = new Node(0);
        len = 0;
        head.next = end;
        end.prev = head;
    }
    
    private Node getNode(int index) {
        if(index<0||index >= len) {
        	return null;
        }
        if(index >= (len>>2)) {
        	int i = len;
        	Node temp = end;
        	while(i!=index) {
        		i--;
        		temp = temp.prev;
        	}
        	return temp;
        }else {
        	int i = -1;
        	Node temp = head;
        	while(i!=index) {
        		i++;
        		temp = temp.next;
        	}
        	return temp;
        }
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node node = getNode(index);
        if(node==null) {
        	return -1;
        }
        return node.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(len, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
    	Node temp;
        if(index>=0&&index<=len) {
        	if(index == len) {
        		temp = end;
        	}else {
        		temp = getNode(index);
        	}
        	Node node = new Node(val);
        	node.next = temp;
        	node.prev = temp.prev;
        	temp.prev.next = node;
        	temp.prev = node;
        	len++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        Node temp = getNode(index);
        if(temp!=null) {
	        temp.prev.next = temp.next;
	        temp.next.prev = temp.prev;
	        temp.next = null;
	        temp.prev = null;
	        len--;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

class MyLinkedList {
	class Node{
		int val;
		Node next;
		public Node(int val) {
			this.val = val;
		}
	}
	
	int len;
	Node head;
	Node end;

    /** Initialize your data structure here. */
    public MyLinkedList() {
    	this.len = 0;
        this.head = new Node(0);
        this.end = new Node(0);
        this.head.next = this.end;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
    	if(index>=len) {
    		return -1;
    	}
    	Node node = head;
        for(int i = 0;i<index;i++) {
        	node = node.next;
        }
        return node.next.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = this.head.next;
        this.head.next = node;
        len++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        this.end.val = val;
        Node node = new Node(0);
        this.end.next = node;
        this.end = node;
        len++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
    	if(index>len) {
    		throw new IndexOutOfBoundsException();
    	}else if(index==len) {
    		addAtTail(val);
    	}else {
    		Node node = head;
            for(int i = 0;i<index;i++) {
            	node = node.next;
            }
            Node add = new Node(val);
            add.next = node.next;
            node.next = add;
            len++;
    	}    	
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
    	if(index>=len) {
    		throw new IndexOutOfBoundsException();
    	}
    	Node node = head;
        for(int i = 0;i<index;i++) {
        	node = node.next;
        }
        node.next = node.next.next;
        len--;
    }
}
/*
设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。

在链表类中实现这些功能：

get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 

示例：

MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
linkedList.get(1);            //返回2
linkedList.deleteAtIndex(1);  //现在链表是1-> 3
linkedList.get(1);            //返回3
 

提示：

所有val值都在 [1, 1000] 之内。
操作次数将在  [1, 1000] 之内。
请不要使用内置的 LinkedList 库。
*/

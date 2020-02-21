package leetcode.test0701to0750;


public class Leetcode705 {
	public static void main(String[] args) {
		MyHashSet hashSet = new MyHashSet();
		hashSet.add(1);
		hashSet.add(2);
		System.out.println(hashSet.contains(1));// 返回 true
		System.out.println(hashSet.contains(3));// 返回 false (未找到)
		hashSet.add(2); 
		System.out.println(hashSet.contains(2)); // 返回 true
		hashSet.remove(2); 
		System.out.println(hashSet.contains(2));// 返回  false (已经被删除)
	}
}

class MyHashSet {
	private class Node{
		public int key;
		
		public int val;
		
		public Node next;
		
		public Node prev;
		
		public Node(int key,int val) {
			this.key = key;
			this.val = val;
		}
	}
	
	private int size = 1<<4;
	
	private int num;
	
	private int maxsize = 1<<20;
	
	private Node[] lists;
	
    /** Initialize your data structure here. */
    public MyHashSet() {
    	num = 0;
        lists = new Node[size];
    }
    
    public void add(int key) {
    	if(!contains(key)) {
	        if(num >= size*3/4) {
	        	resize();
	        }
	        Node node = new Node(key, 0);
	        put(lists, node);
    	}
    }
    
    private void resize() {
    	if(size<maxsize) {
    		size = size<<1;
    		Node[] temp = new Node[size];
    		for(Node head:lists) {
    			while(head!=null) {
    				Node n = head;
    				head = head.next;
    				put(temp, n);
    			}
    		}
    		lists = temp;
    	}
    }
    
    private void put(Node[] ns,Node node) {
    	Node head = ns[node.key%size];
    	ns[node.key%size] = node;
    	if(head!=null) {
    		node.next = head;
    		head.prev = node;
    	}
    }
    
    public void remove(int key) {
    	Node head = lists[key%size];
    	Node node = contains(head, key);
    	if(node!=null) {
    		if(node == head) {
    			lists[key%size]=head.next;
    		}else {
    			node.prev.next = node.next;
    			if(node.next!=null) {
    				node.next.prev = node.prev;
    			}
    		}
    	}
    	num--;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
    	Node head = lists[key%size];
    	Node node = contains(head, key);
        return node!=null;
    }
    
    private Node contains(Node head,int key) {
		Node temp = head;
		while(temp!=null) {
			if(temp.key==key) {
				return temp;
			}
			temp = temp.next;
		}
		return null;
	}
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */

/*
不使用任何内建的哈希表库设计一个哈希集合

具体地说，你的设计应该包含以下的功能

add(value)：向哈希集合中插入一个值。
contains(value) ：返回哈希集合中是否存在这个值。
remove(value)：将给定值从哈希集合中删除。如果哈希集合中没有这个值，什么也不做。

示例:

MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // 返回 true
hashSet.contains(3);    // 返回 false (未找到)
hashSet.add(2);          
hashSet.contains(2);    // 返回 true
hashSet.remove(2);          
hashSet.contains(2);    // 返回  false (已经被删除)

注意：

所有的值都在 [0, 1000000]的范围内。
操作的总数目在[1, 10000]范围内。
不要使用内建的哈希集合库。
*/

package leetcode.test0701to0750;

public class Leetcode706 {

}
class MyHashMap {
	
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

    /** Initialize your data structure here. */
    public MyHashMap() {
    	num = 0;
        lists = new Node[size];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
    	Node head = lists[key%size];
    	Node n = contains(head, key);
    	if(n==null) {
	        if(num >= size*3/4) {
	        	resize();
	        }
	        Node node = new Node(key, value);
	        put(lists, node);
	        num++;
    	}else {
    		n.val = value;
    	}
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
    	Node head = lists[key%size];
    	Node node = contains(head, key);
        return node!=null?node.val:-1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
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
    
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
/*
不使用任何内建的哈希表库设计一个哈希映射

具体地说，你的设计应该包含以下的功能

put(key, value)：向哈希映射中插入(键,值)的数值对。如果键对应的值已经存在，更新这个值。
get(key)：返回给定的键所对应的值，如果映射中不包含这个键，返回-1。
remove(key)：如果映射中存在这个键，删除这个数值对。

示例：

MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // 返回 1
hashMap.get(3);            // 返回 -1 (未找到)
hashMap.put(2, 1);         // 更新已有的值
hashMap.get(2);            // 返回 1 
hashMap.remove(2);         // 删除键为2的数据
hashMap.get(2);            // 返回 -1 (未找到) 

注意：

所有的值都在 [1, 1000000]的范围内。
操作的总数目在[1, 10000]范围内。
不要使用内建的哈希库。
*/

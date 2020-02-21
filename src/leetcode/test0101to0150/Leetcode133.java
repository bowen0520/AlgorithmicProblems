package leetcode.test0101to0150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import leetcode.referenceclass.Node;

public class Leetcode133 {
	//dfs递归写法
	/*public Node cloneGraph(Node node) {
		if(node==null) {
			return null;
		}
	    Map<Node, Node> map = new HashMap<Node, Node>();
	    return cloneGraph(node, map);
	}
	
	public Node cloneGraph(Node node,Map<Node,Node> map) {
		if(!map.containsKey(node)) {
			map.put(node, new Node(node.val,new LinkedList<Node>()));
		}
		Node copy = map.get(node);
		for(Node o:node.neighbors){
			if (map.containsKey(o)) {
				copy.neighbors.add(map.get(o));
			}else {
				copy.neighbors.add(cloneGraph(o, map));
			}
		}
		return copy;
	}*/
	//dfs非递归
	/*public Node cloneGraph(Node node) {
		if(node==null) {
			return null;
		}
	    Map<Node, Node> map = new HashMap<Node, Node>();
	    Deque<Node> deq = new ArrayDeque<Node>();
	    deq.push(node);
	    while(!deq.isEmpty()) {
	    	Node n = deq.pop();
	    	if(!map.containsKey(n)) {
				map.put(n, new Node(n.val,new LinkedList<Node>()));
			}
			Node copy = map.get(n);
			for(Node o:n.neighbors){
				if (!map.containsKey(o)) {
					map.put(o, new Node(o.val,new LinkedList<Node>()));
					deq.push(o);
				}
				copy.neighbors.add(map.get(o));
			}
	    }
	    return map.get(node);
	}*/
	//bfs
	public Node cloneGraph(Node node) {
		if(node==null) {
			return null;
		}
	    Map<Node, Node> map = new HashMap<Node, Node>();
	    Queue<Node> deq = new ArrayDeque<Node>();
	    deq.offer(node);
	    while(!deq.isEmpty()) {
	    	Node n = deq.poll();
	    	if(!map.containsKey(n)) {
				map.put(n, new Node(n.val,new LinkedList<Node>()));
			}
			Node copy = map.get(n);
			for(Node o:n.neighbors){
				if (!map.containsKey(o)) {
					map.put(o, new Node(o.val,new LinkedList<Node>()));
					deq.offer(o);
				}
				copy.neighbors.add(map.get(o));
			}
	    }
	    return map.get(node);
	}
	
}
/*
给定无向连通图中一个节点的引用，返回该图的深拷贝（克隆）。图中的每个节点都包含它的值 val（Int） 和其邻居的列表（list[Node]）。

示例：

输入：
{"$id":"1","neighbors":[{"$id":"2","neighbors":[{"$ref":"1"},{"$id":"3","neighbors":[{"$ref":"2"},{"$id":"4","neighbors":[{"$ref":"3"},{"$ref":"1"}],"val":4}],"val":3}],"val":2},{"$ref":"4"}],"val":1}

解释：
节点 1 的值是 1，它有两个邻居：节点 2 和 4 。
节点 2 的值是 2，它有两个邻居：节点 1 和 3 。
节点 3 的值是 3，它有两个邻居：节点 2 和 4 。
节点 4 的值是 4，它有两个邻居：节点 1 和 3 。
 

提示：

节点数介于 1 到 100 之间。
无向图是一个简单图，这意味着图中没有重复的边，也没有自环。
由于图是无向的，如果节点 p 是节点 q 的邻居，那么节点 q 也必须是节点 p 的邻居。
必须将给定节点的拷贝作为对克隆图的引用返回。
*/

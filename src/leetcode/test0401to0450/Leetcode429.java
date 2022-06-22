package leetcode.test0401to0450;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Leetcode429 {
    public List<List<Integer>> levelOrder(Node root) {
    	List<List<Integer>> lists = new ArrayList<List<Integer>>();
    	
    	Queue<Node> queue = new LinkedList<Node>();
    	
    	queue.offer(root);
    	
    	while(!queue.isEmpty()) {
    		int len = queue.size();
    		List<Integer> list = new ArrayList<Integer>();
    		
    		for(int i = 0; i < len; i++) {
    			Node tmpNode = queue.poll();
    			if(tmpNode == null){
                    continue;
                }
    			list.add(tmpNode.val);
    			for(Node n: tmpNode.children) {
    				queue.offer(n);
    			}
    		}
    		lists.add(list);
    	}
    	
    	return lists;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

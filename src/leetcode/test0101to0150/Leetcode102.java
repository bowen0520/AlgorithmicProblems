package leetcode.test0101to0150;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.referenceclass.TreeNode;

public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
		
		if(root == null) {
			return list;
		}
		
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		
		que.add(root);
		
		while(!que.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			int len = que.size();
			for(int i = 0; i < len; i++){
				TreeNode node = que.poll();
				temp.add(node.val);
				
				if(node.left != null) {
					que.offer(node.left);
				}
				
				if(node.right != null) {
					que.offer(node.right);
				}
			}
			list.add(temp);
		}
		
		return list;
    }
}
/*
给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
*/

package leetcode.test0101to0150;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.referenceclass.TreeNode;

public class Leetcode144 {
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		
		
		if(root == null) {
			return list;
		}
		
		list.add(root.val);
		
		list.addAll(preorderTraversal(root.left));
		
		list.addAll(preorderTraversal(root.right));
		
		return list;
    }
	
	
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		
		
		if(root == null) {
			return list;
		}
		
		Deque<TreeNode> que = new LinkedList<TreeNode>();
		
		que.add(root);
		
		while(!que.isEmpty()) {
			TreeNode temp = que.pop();
			
			list.add(temp.val);
			
			if(temp.right != null) {
				que.push(temp.right);
			}
			
			if(temp.left != null) {
				que.push(temp.left);
			}
		}
		
		return list;
    }
}
/*
给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
*/

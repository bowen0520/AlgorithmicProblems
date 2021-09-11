package leetcode.test0101to0150;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import leetcode.referenceclass.TreeNode;

public class Leetcode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
		
		if(root == null) {
			return list;
		}
		
		list.addAll(postorderTraversal(root.left));
		
		list.addAll(postorderTraversal(root.right));
		
		list.add(root.val);
		
		return list;
    }
    
    
    public List<Integer> postorderTraversal2(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
		
		
		if(root == null) {
			return list;
		}
		
		Deque<TreeNode> que = new LinkedList<TreeNode>();
		
		que.add(root);
		
		while(!que.isEmpty()) {
			TreeNode temp = que.pop();
			
			list.add(temp.val);
			
			if(temp.left != null) {
				que.push(temp.left);
			}
			
			if(temp.right != null) {
				que.push(temp.right);
			}
		}
		
		List<Integer> newList = new ArrayList<Integer>();
		
		for(int i = list.size()-1; i >= 0; i--) {
			newList.add(list.get(i));
		}
		
		return newList;
    }
}
/*
给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
*/

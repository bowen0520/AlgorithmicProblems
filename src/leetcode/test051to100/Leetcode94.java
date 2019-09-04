package leetcode.test051to100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import leetcode.referenceclass.TreeNode;

public class Leetcode94 {
	//递归dfs
	/*public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) {
        	return list;
        }
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }*/
	//迭代dfs
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null) {
        	return list;
        }
        Deque<TreeNode> deq = new ArrayDeque<TreeNode>();
        Set<TreeNode> set = new HashSet<TreeNode>();
        deq.push(root);
        set.add(root);
        while(!deq.isEmpty()) {
        	TreeNode node = deq.peek();
        	if(node.left!=null&&(!set.contains(node.left))) {
        		deq.push(node.left);
        		set.add(node.left);
        	}else {
        		node = deq.pop();
        		list.add(node.val);
        		if(node.right!=null&&(!set.contains(node.right))) {
        			deq.push(node.right);
            		set.add(node.right);
        		}
        	}
        }
        return list;
    }
}
/*
给定一个二叉树，返回它的中序 遍历。

示例:

输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
进阶: 递归算法很简单，你可以通过迭代算法完成吗？
*/
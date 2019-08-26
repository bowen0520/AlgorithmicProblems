package pointoffer;

import java.util.LinkedList;
import java.util.Queue;

import pointoffer.referenceclass.TreeNode;

public class Offer38 {
	/*public int TreeDepth(TreeNode root) {
	    return TreeDepth(root,0);
	}
	public int TreeDepth(TreeNode root,int deep) {
		if(root == null) {
			return deep;
		}
	    return Math.max(TreeDepth(root.left,deep+1),TreeDepth(root.right, deep+1));
	}*/
	
	
	/*public int TreeDepth(TreeNode root) {
	    if(root == null){
	        return 0;
	    }
	    return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
	}*/
	
	public int TreeDepth(TreeNode root) {
	    if(root == null){
	        return 0;
	    }
	    Queue<TreeNode> que = new LinkedList<TreeNode>();
	    que.add(root);
	    int count = 0;
	    while(!que.isEmpty()) {
	    	count++;
	    	int size = que.size();
	    	for(int i = 0;i<size;i++) {
	    		TreeNode node = que.poll();
	    		if(node.left!=null) {
	    			que.offer(node.left);
	    		}
	    		if(node.right!=null) {
	    			que.offer(node.right);
	    		}
	    	}
	    }
	    return count;
	}
	
}
/*
题目描述
输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
*/
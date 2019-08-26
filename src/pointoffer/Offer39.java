package pointoffer;

import pointoffer.referenceclass.TreeNode;

public class Offer39 {
	public boolean IsBalanced_Solution(TreeNode root) {
        return TreeDepth(root)!=-1;
    }
	
	public int TreeDepth(TreeNode root) {
	    if(root == null){
	        return 0;
	    }
	    int left = TreeDepth(root.left);
	    int right = TreeDepth(root.right);
	    
	    if(left==-1||right==-1) {
	    	return -1;
	    }
	    
	    if(Math.abs(left-right)>1) {
	    	return -1;
	    }
	    
	    return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
	}
	
}
/*
题目描述
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
*/
package pointoffer;

import pointoffer.referenceclass.TreeNode;

public class Offer26 {
	/*public TreeNode Convert(TreeNode pRootOfTree) {
		if(pRootOfTree==null) {
			return null;
		}
		TreeNode lHead = Convert(pRootOfTree.left);
		TreeNode rHead = Convert(pRootOfTree.right);
		TreeNode head = null;
		if(lHead!=null) {
			head = lHead;
			TreeNode temp = lHead;
			while(temp.right!=null) {
	    		temp = temp.right;
	    	}
	    	temp.right = pRootOfTree;
	    	pRootOfTree.left = temp;
	    	pRootOfTree.right = rHead;
	    	if(rHead!=null) {
	    		rHead.left = pRootOfTree;
	    	}
		}else {
			head = pRootOfTree;
			pRootOfTree.right = rHead;
	    	if(rHead!=null) {
	    		rHead.left = pRootOfTree;
	    	}
		}
	    return head;
	}*/
	
	public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        if(pRootOfTree.left==null&&pRootOfTree.right==null){
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftEnd = getRight(left);
        if(left!=null){
            pRootOfTree.left = leftEnd;
            leftEnd.right = pRootOfTree;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(right!=null){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left==null?pRootOfTree:left;
    }
     
    public TreeNode getRight(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        while(pRootOfTree.right!=null){
            pRootOfTree = pRootOfTree.right;
        }
        return pRootOfTree;
    }
}
/*
题目描述
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
*/
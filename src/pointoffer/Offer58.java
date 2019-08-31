package pointoffer;

import pointoffer.referenceclass.TreeNode;

public class Offer58 {
	boolean isSymmetrical(TreeNode pRoot){
		if(pRoot==null) {
			return true;
		}
		if(pRoot.left==null&&pRoot.right==null) {
			return true;
		}else if(pRoot.left!=null&&pRoot.right!=null) {
			return (pRoot.left.val==pRoot.right.val)&&isSymmetrical(pRoot.left, pRoot.right);
		}else {
			return false;
		}
        
    }
	boolean isSymmetrical(TreeNode left,TreeNode right) {
		if(left==null&&right==null) {
			return true;
		}else if(left!=null&&right!=null) {
			return (left.val==right.val)&&isSymmetrical(left.left, right.right)&&isSymmetrical(left.right, right.left);
		}else {
			return false;
		}
		
		
		/*if(left.val!=right.val) {
			return false;
		}
		if(left.right==null&&left.left==null&&right.left==null&&right.right==null) {
			return true;
		}
		boolean flag1;
		if(left.left==null&&right.right==null) {
			flag1 = true;
		}else if(left.left!=null&&right.right!=null) {
			flag1=isSymmetrical(left.left, right.right);
		}else {
			flag1 = false;
		}
		
		boolean flag2;
		if(left.right==null&&right.left==null) {
			flag2 = true;
		}else if(left.right!=null&&right.left!=null) {
			flag2=isSymmetrical(left.right, right.left);
		}else {
			flag2 = false;
		}
		
		return flag1&&flag2;*/
	}
}
/*
题目描述
请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
*/
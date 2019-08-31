package pointoffer;

import pointoffer.referenceclass.TreeLinkNode;

public class Offer57 {
	public TreeLinkNode GetNext(TreeLinkNode pNode){
		if(pNode==null) {
			return null;
		}
        if(pNode.right!=null) {
        	TreeLinkNode temp = pNode.right;
        	while(temp.left!=null) {
        		temp = temp.left;
        	}
        	return temp;
        }
        if(pNode.next!=null) {
        	TreeLinkNode temp = pNode;
        	while(temp.next!=null&&temp.next.left!=temp) {
        		temp = temp.next;
        	}
        	return temp.next;
        }
        return null;
    }
}
/*
题目描述
给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
*/
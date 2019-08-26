package pointoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import pointoffer.referenceclass.TreeNode;

public class Offer22 {
	public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(root==null) {
			return list;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		while(!que.isEmpty()) {
			TreeNode node = que.poll();
			list.add(node.val);
			if(node.left!=null) {
				que.offer(node.left);
			}
			if(node.right!=null) {
				que.offer(node.right);
			}
		}
		return list;
    }
}
/*
题目描述
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
*/
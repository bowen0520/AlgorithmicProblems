package pointoffer;

import java.util.LinkedList;
import java.util.Queue;

import pointoffer.referenceclass.TreeNode;

public class Offer17 {
	public boolean HasSubtree(TreeNode root1,TreeNode root2) {
		if(root1==null||root2==null) {
			return false;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root1);
		while(!que.isEmpty()) {
			TreeNode t = que.poll();
			if(help(t,root2)) {
				return true;
			}
			if(t.left!=null) {
				que.offer(t.left);
			}
			if(t.right!=null) {
				que.offer(t.right);
			}
		}
		return false;
    }
	public boolean help(TreeNode root1,TreeNode root2) {
		Queue<TreeNode> que1 = new LinkedList<TreeNode>();
		Queue<TreeNode> que2 = new LinkedList<TreeNode>();
		que1.add(root1);
		que2.add(root2);
		while(!que2.isEmpty()) {
			TreeNode t1 = que1.poll();
			TreeNode t2 = que2.poll();
			if(!equals(t1, t2)) {
				return false;
			}
			if(t1!=null) {
				que1.offer(t1.left);
				que1.offer(t1.right);
			}
			if(t2!=null) {
				que2.offer(t2.left);
				que2.offer(t2.right);
			}
		}
		return true;
	}
	
	public boolean equals(TreeNode t1,TreeNode t2) {
		return t2==null||(t1!=null&&t2!=null&&t1.val==t2.val);
	}
}
/*
 * 题目描述 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
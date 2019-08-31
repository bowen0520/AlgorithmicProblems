package pointoffer;

import java.util.LinkedList;
import java.util.Queue;

import pointoffer.referenceclass.TreeNode;

public class Offer61 {
	String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.add(root);
		boolean flag = true;
		while(flag) {
			flag = false;
			int size = que.size();
			for(int i =0;i<size;i++) {
				TreeNode node = que.poll();
				if(node==null) {
					sb.append("#!");
					que.add(null);
					que.add(null);
				}else {
					sb.append(node.val+"!");
					if(node.left!=null) {
						flag = true;
					}
					que.add(node.left);
					if(node.right!=null) {
						flag = true;
					}
					que.offer(node.right);
				}
			}
		}
		String str = sb.toString();
		return str.substring(0,str.length()-1);
	}

	TreeNode Deserialize(String str) {
		String[] ss = str.split("!");
		TreeNode[] nodes = new TreeNode[ss.length];
		for(int i =0;i<ss.length;i++) {
			if(!"#".equals(ss[i])) {
				nodes[i] = new TreeNode(Integer.parseInt(ss[i]));
			}
		}
		
		for(int i =0;i<(nodes.length/2)+1;i++) {
			if(nodes[i]!=null) {
				int il = 2*i+1;
				int ir = 2*i+2;
				if(il<nodes.length) {
					nodes[i].left = nodes[il];
				}
				if(ir<nodes.length) {
					nodes[i].right = nodes[ir];
				}
			}
		}
		return nodes[0];
	}
}
/*
题目描述
请实现两个函数，分别用来序列化和反序列化二叉树

二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。

二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。

*/
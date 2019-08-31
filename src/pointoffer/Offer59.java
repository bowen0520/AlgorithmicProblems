package pointoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import pointoffer.referenceclass.TreeNode;

public class Offer59 {
	public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
	    ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
	    if(pRoot==null){
	        return lists;
	    }
	    Queue<TreeNode> que = new LinkedList<TreeNode>();
	    que.offer(pRoot);
	    while(!que.isEmpty()){
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        int size = que.size();
	        for(int i = 0;i<size;i++) {
	        	TreeNode node = que.poll();
	            if(node.left!=null){
	                que.offer(node.left);
	            }
	            if(node.right!=null){
	                que.offer(node.right);
	            }
	            int index = (lists.size()+1)%2==1?list.size():0;
	            list.add(index,node.val);
	        }
	        lists.add(list);
	    }
	    return lists;
	}
	
}
/*
题目描述
请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
*/
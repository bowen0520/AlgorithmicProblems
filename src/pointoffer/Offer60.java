package pointoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import pointoffer.referenceclass.TreeNode;

public class Offer60 {
	ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if(pRoot==null){
            return lists;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(pRoot);
        while(!que.isEmpty()){
            ArrayList<Integer> list = new ArrayList<>();
            int size = que.size();
            for(int i = 0;i<size;i++){
                TreeNode node = que.poll();
                if(node.left!=null){
                    que.offer(node.left);
                }
                if(node.right!=null){
                    que.offer(node.right);
                }
                list.add(node.val);
                System.out.print(node.val+" ");
            }
            lists.add(list);
            System.out.println();
        }
        return lists;
    }
}
/*
题目描述
从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
*/
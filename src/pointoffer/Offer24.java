package pointoffer;

import java.util.ArrayList;

import pointoffer.referenceclass.TreeNode;

public class Offer24 {
	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null){
            return lists;
        }
        list.add(root.val);
        target -= root.val;
        if(target>=0){
            if(target==0&&root.left==null&&root.right==null){
                ArrayList<Integer> nList = new ArrayList<>(list);
                lists.add(nList);
                list.remove(list.size()-1);
                return lists;
            }
            FindPath(root.left, target);
            FindPath(root.right, target);
            list.remove(list.size()-1);
        }
        return lists;
    }
}
/*
题目描述
输入一颗二叉树的根节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
(注意: 在返回值的list中，数组长度大的数组靠前)
*/
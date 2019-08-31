package pointoffer;

import java.util.ArrayList;
import java.util.List;

import pointoffer.referenceclass.TreeNode;

public class Offer62 {
	TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot==null){
            return null;
        }
        List<TreeNode> list = getList(pRoot);
        if(k<=list.size()&&k>0){
            return list.get(k-1);
        }
        return null;
    }
    List<TreeNode> getList(TreeNode pRoot){
        List<TreeNode> list = new ArrayList<TreeNode>();
        if(pRoot==null){
            return list;
        }
        list.addAll(getList(pRoot.left));
        list.add(pRoot);
        list.addAll(getList(pRoot.right));
        return list;
    }
}
/*
题目描述
给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
*/
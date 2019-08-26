package pointoffer;

import java.util.HashMap;
import java.util.Map;

import pointoffer.referenceclass.TreeNode;

public class Offer04 {
	public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i<in.length;i++) {
			map.put(in[i], i);
		}
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1,map);
    }
	public TreeNode reConstructBinaryTree(int[] pre,int preS,int preE,int[] in,int inS,int inE,Map<Integer, Integer> map) {
        if(preS>preE) {
        	return null;
        }
        TreeNode treeNode = new TreeNode(pre[preS]);
        int i = map.get(pre[preS]);
        treeNode.left = reConstructBinaryTree(pre,preS+1,preS+i-inS,in,inS,i-1,map);//左子树
        treeNode.right = reConstructBinaryTree(pre,preS+i-inS+1,preE,in,i+1,inE,map);//右子树
        return treeNode;
    }
}
/*
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
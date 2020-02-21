package leetcode.test0651to0700;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.referenceclass.TreeNode;

public class Leetcode652 {
	Map<String, List<TreeNode>> map = new HashMap<String, List<TreeNode>>();
	
	public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        getBooks(root);
        List<TreeNode> list = new ArrayList<TreeNode>();
        map.forEach((k,v)->{
        	if(v.size()>1) {
        		list.add(v.get(0));
        	}
        });
        return list;
    }
	
	public String getBooks(TreeNode root){
		if(root==null) {
			return "";
		}
		
		String str = getBooks(root.left)+","+root.val+","+getBooks(root.right);
		
		if(map.containsKey(str)) {
			map.get(str).add(root);
		}else {
			List<TreeNode> list = new ArrayList<TreeNode>();
			list.add(root);
			map.put(str,list);
		}
		return str;
	}
}
/*
给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。

两棵树重复是指它们具有相同的结构以及相同的结点值。

示例 1：

        1
       / \
      2   3
     /   / \
    4   2   4
       /
      4
下面是两个重复的子树：

      2
     /
    4
和

    4
因此，你需要以列表的形式返回上述重复子树的根结点。
*/

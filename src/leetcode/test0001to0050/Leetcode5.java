package leetcode.test0001to0050;

import java.util.HashMap;
import java.util.Map;

import leetcode.referenceclass.TreeNode;

public class Leetcode5 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return inorderSuccessor(root, null, p);
    }
    
    public TreeNode inorderSuccessor(TreeNode root, TreeNode parent, TreeNode target) {
        if(root == target) {
        	if(root.right != null) {
        		TreeNode anNode = root.right;
        		
        		while(anNode.left != null) {
        			anNode = anNode.left;
        		} 
        		
        		return anNode;
        	}else {
				return parent;
			}
        }else if(root.val > target.val){
			return inorderSuccessor(root.left, root, target);
		}else {
			return inorderSuccessor(root.right, null, target);
		}
    }
    

}

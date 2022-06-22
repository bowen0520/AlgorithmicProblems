package leetcode.test0501to0550;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.referenceclass.TreeNode;

public class Leetcode513 {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode aNode = root;
        queue.add(root);
        while (!queue.isEmpty()) {
        	TreeNode tmpNode = queue.poll();
        	aNode = tmpNode;
        	
			if(tmpNode.right != null) {
				queue.offer(tmpNode.right);
			}
			if(tmpNode.left != null) {
				queue.offer(tmpNode.left);
			}
		}
        
        return aNode.val;
    }
}

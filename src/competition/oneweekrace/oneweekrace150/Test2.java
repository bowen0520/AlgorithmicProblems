package competition.oneweekrace.oneweekrace150;

import java.util.LinkedList;
import java.util.Queue;

import pointoffer.referenceclass.TreeNode;

public class Test2 {
	public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int maxSum = Integer.MIN_VALUE;
        int count = 1;
        int min = 1;
        queue.add(root);
        while(!queue.isEmpty()) {
        	int size = queue.size();
        	int sum = 0;
        	for(int i = 0;i<size;i++) {
        		TreeNode treeNode = queue.poll();
        		sum += treeNode.val;
        		if(treeNode.left!=null) {
        			queue.offer(treeNode.left);
        		}
        		if(treeNode.right!=null) {
        			queue.offer(treeNode.right);
        		}
        	}
        	if(sum>maxSum) {
        		maxSum = sum;
        		min = count;
        	}
        	count++;
        }
        return min;
    }
}

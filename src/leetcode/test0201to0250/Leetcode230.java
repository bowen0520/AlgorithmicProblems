package leetcode.test0201to0250;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import leetcode.referenceclass.TreeNode;

public class Leetcode230 {
    public int kthSmallest(TreeNode root, int k) {
    	Deque<Integer> bookDeque = new LinkedList<Integer>();
    	kthSmallest(root, k, bookDeque);
    	return bookDeque.peek();
    }
    
    public void kthSmallest(TreeNode root, int k, Deque<Integer> deq) {
    	if(deq.isEmpty()) {
    		deq.push(root.val);
    	}else {
    		int num = root.val;
    		Deque<Integer> bookDeque = new LinkedList<Integer>();
			while(!deq.isEmpty() && deq.peek() > num) {
				bookDeque.push(deq.pop());
			}
			bookDeque.push(num);
			while(deq.size() < k && !bookDeque.isEmpty()) {
				deq.push(bookDeque.pop());
			}
		}
    	
    	
    	
    	if(root.right != null) {
    		kthSmallest(root.right, k, deq);
    	}
    	
    	if(root.left != null) {
    		kthSmallest(root.left, k, deq);
    	}
    }
    
    public int kthSmallest2(TreeNode root, int k) {
    	
    	Set<TreeNode> bookNodes = new HashSet<TreeNode>();
    	
    	Deque<TreeNode> deqBook = new LinkedList<TreeNode>();
    	
    	Deque<Integer> bookDeque = new LinkedList<Integer>();
    	
    	deqBook.push(root);
    	bookNodes.add(root);
    	
    	while(!deqBook.isEmpty()) {
    		TreeNode temp = deqBook.peek();
    		if(temp.left != null && !bookNodes.contains(temp.left)) {
    			deqBook.push(temp.left);
    	    	bookNodes.add(temp.left);
    		}else {
				bookDeque.push(temp.val);
				if(temp.right != null && !bookNodes.contains(temp.right)) {
					temp = deqBook.pop();
	    			deqBook.push(temp.right);
	    	    	bookNodes.add(temp.right);
	    		}
			}
    		
    		if(bookDeque.size() == k) {
    			return bookDeque.peek();
    		}
    	}
    	return -1;
    }
}
/*
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

 

示例 1：


输入：root = [3,1,4,null,2], k = 1
输出：1
示例 2：


输入：root = [5,3,6,2,4,null,null,1], k = 3
输出：3
 

 

提示：

树中的节点数为 n 。
1 <= k <= n <= 104
0 <= Node.val <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
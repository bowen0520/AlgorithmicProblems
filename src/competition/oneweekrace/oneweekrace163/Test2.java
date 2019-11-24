package competition.oneweekrace.oneweekrace163;

import java.util.ArrayList;
import java.util.List;

import leetcode.referenceclass.TreeNode;

public class Test2 {
	TreeNode root;
	
    public Test2(TreeNode root) {
        root.val = 0;
        help(root);
        this.root = root;
    }
    
    public void help(TreeNode node) {
    	if(node.left!=null) {
    		node.left.val = node.val*2+1;
    		help(node.left);
    	}
    	
    	if(node.right!=null) {
    		node.right.val = node.val*2+2;
    		help(node.right);
    	}
    }
    
    public boolean find(int target) {
    	List<Boolean> list = new ArrayList<Boolean>();
    	
    	int t = target;
        while(t!=0) {
        	if(t%2==1) {
        		list.add(true);
        		t = (t-1)/2;
        	}else {
        		list.add(false);
        		t = (t-2)/2;
        	}
        }
        
        TreeNode temp = this.root;
        
        for(int i = list.size()-1;i>=0;i--) {
        	if(list.get(i)) {
        		temp = temp.left;
        	}else {
        		temp = temp.right;
        	}
        	if(temp==null) {
        		return false;
        	}
        }
        return true;
    }
    
    public static void main(String[] args) {
		new 
	}
}

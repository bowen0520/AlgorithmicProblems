package leetcode.test0501to0550;

import java.util.HashSet;
import java.util.Set;

public class Leetcode532 {
    public int findPairs(int[] nums, int k) {
    	Set<Integer> numSet = new HashSet<Integer>();
    	
    	Set<Integer> bookSet = new HashSet<Integer>();
    	
    	for(int n: nums) {
    		if(numSet.contains(n + k)) {
    			bookSet.add(n + k);
    		}
    		
    		if(numSet.contains(n - k)) {
    			bookSet.add(n);
    		}
    		numSet.add(n);
    	}
    	
    	return bookSet.size();
    }
}

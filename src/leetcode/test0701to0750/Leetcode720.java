package leetcode.test0701to0750;

import java.util.ArrayList;
import java.util.List;

public class Leetcode720 {
    public int smallestDistancePair(int[] nums, int k) {
    	List<int[]> list = new ArrayList<int[]>();
    	
    	for(int i = 0; i < nums.length - 1; i++) {
    		for(int j = i + 1; j < nums.length; i++) {
    			list.add(new int[] {nums[i], nums[j]});
    		}
    	}
    	
    	list.sort((int[] a, int[] b) -> {
    		int ana = Math.abs(a[0] - a[1]);
    		int anb = Math.abs(b[0] - b[1]);
    		
    		return ana -anb;
    	});
    	
    	int[] an = list.get(k - 1);
    	
    	return Math.abs(an[0] - an[1]);
    }
}

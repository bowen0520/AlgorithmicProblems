package leetcode.test0301to0350;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode350 {
    public int[] intersect(int[] nums1, int[] nums2) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
        for(int n:nums1) {
        	if(map.containsKey(n)) {
        		map.put(n,map.get(n)+1);
        	}else {
        		map.put(n, 1);
        	}
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int n: nums2) {
        	if(map.containsKey(n)&&map.get(n)>0) {
        		list.add(n);
        		map.put(n, map.get(n)-1);
        	}
        }
        
        int[] nums = new int[list.size()];
        
        for(int i = 0;i<nums.length;i++) {
        	nums[i] = list.get(i);
        }
        
        return nums;
    }
}

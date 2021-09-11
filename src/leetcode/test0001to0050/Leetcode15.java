package leetcode.test0001to0050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	
    	if(nums.length<3) {
    		return result;
    	}
    	
    	Arrays.sort(nums);
    	
    	for(int i = 0;i<nums.length-2;i++) {
    		if(i>0 && nums[i] == nums[i-1]) {
    			continue;
    		}
    		
    		int left = i + 1;
    		int right = nums.length-1;
    		
    		while(left < right) {
    			if(nums[left] + nums[right] == -nums[i]) {
    				List<Integer> list = new ArrayList<Integer>();
    				list.add(nums[i]);
    				list.add(nums[left]);
    				list.add(nums[right]);
    				result.add(list);
    				
    				left++;
    				right--;
    				while(left<right && nums[left]==nums[left-1]) {
    					left++;
    				}
    				while(left<right && nums[right]==nums[right+1]) {
    					right--;
    				}
    			}else if(nums[left] + nums[right] > -nums[i]) {
    				right--;
    			}else {
    				left ++;
    			}
    		}
    	}
    	
    	return result;
    }
}

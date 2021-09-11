package leetcode.test0001to0050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode46 {
	
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		System.out.println(new Leetcode46().permute(nums).toString());
		
		
		String key = Arrays.toString(nums);
		//System.out.println(key);
	}
	
	
	static Map<String, List<List<Integer>>> map = new HashMap<String, List<List<Integer>>>();
	
    public List<List<Integer>> permute(int[] nums) {
    	String key = Arrays.toString(nums);
    	if(map.containsKey(key)) {
    		//System.out.println(key + map.get(key).toString());
    		return map.get(key);
    	}
    	
    	List<List<Integer>> value = new ArrayList<List<Integer>>();
    	
    	if(nums.length<=1) {
    		List<Integer> temp = new ArrayList<Integer>();
    		temp.add(nums[0]);
    		value.add(temp);
    		map.put(key,value);
    		//System.out.println(key + value.toString());
    		return value;
    	}
    	
    	for(int i = 0;i<nums.length;i++) {
    		List<List<Integer>> tmp = permute(getNew(nums, i));
    		for(List<Integer> list:tmp) {
    			List<Integer> tp = new ArrayList<Integer>();
    			tp.add(nums[i]);
    			tp.addAll(list);
    			value.add(tp);
    		}
    	}
    	map.put(key,value);
    	//System.out.println(key + value.toString());
		return value;    	
    }
    
    
    
    public int[] getNew(int[] nums, int in) {
    	int[] nn = new int[nums.length-1];
    	int t = 0;
    	for(int i = 0;i<nums.length ;i++) {
    		if(i!=in) {
    			nn[t++] = nums[i];
    		}
    	}
    	return nn;
    }
}

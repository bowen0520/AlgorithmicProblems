package leetcode.test0201to0250;

import java.util.HashMap;
import java.util.Map;

public class Leetoce219 {
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
    	Map<Integer, Integer> book = new HashMap<Integer, Integer>();
    	for(int i = 0; i < nums.length && i <= k ; i++) {
    		book.put(nums[i], book.getOrDefault(nums[i], 0) + 1);
    		
    		if(book.get(nums[i]) > 1) {
    			return true;
    		}
    	}
    	
    	for(int i = k + 1; i < nums.length; i++) {
    		book.put(nums[i], book.getOrDefault(nums[i], 0) + 1);
    		book.put(nums[i - k - 1], book.get(nums[i - k - 1]) - 1);
    		if(book.get(nums[i]) > 1) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	Map<Integer, Integer> book = new HashMap<Integer, Integer>();
    	
    	
    	for(int i = 0; i < nums.length; i++) {
    		if(book.containsKey(nums[i]) && i - book.get(nums[i]) <= k) {
    			return true;
    		}
    		
    		book.put(nums[i], i);
    	}
    	return false;
    }
}
/*
给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i - j) <= k 。如果存在，返回 true ；否则，返回 false 。

 

示例 1：

输入：nums = [1,2,3,1], k = 3
输出：true
示例 2：

输入：nums = [1,0,1,1], k = 1
输出：true
示例 3：

输入：nums = [1,2,3,1,2,3], k = 2
输出：false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/contains-duplicate-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
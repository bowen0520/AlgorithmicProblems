package leetcode.test0201to0250;

public class Leetcode209 {
	/*public int minSubArrayLen(int s, int[] nums) {
		int len = nums.length;
		if(len==0) {
			return 0;
		}
		
		int[] sum = new int[len];
		sum[0] = nums[0];
		for(int k = 1;k<len;k++) {
			sum[k] = sum[k-1]+nums[k];
		}
		
	    int n = 1;        
	    while(n<=nums.length) {
	    	int an = sum[n-1];
	    	if(an>=s) {
	    		return n;
	    	}
	    	for(int i = 1;i<=nums.length-n;i++) {
	    		an = sum[i+n-1]-sum[i-1];
	    		if(an>=s) {
	        		return n;
	        	}
	    	}
	    	n++;
	    }
	    return 0;
	}*/
	
	public int minSubArrayLen(int s, int[] nums) {
		int len = nums.length;
		if(len==0) {
			return 0;
		}
		
		int start = 0;
		int end = 0;
		int sum = 0;
		
        int n = len+1; 
        
        while(end<len) {
        	sum += nums[end];
        	while(sum>=s&&start<=end) {
        		n = Math.min(n, end-start+1);
        		sum-=nums[start];
        		start++;
        	}
        	end++;
        }
        return n==len+1?0:n;
    }
}
/*
给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。

示例: 

输入: s = 7, nums = [2,3,1,2,4,3]
输出: 2
解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
进阶:

如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
*/

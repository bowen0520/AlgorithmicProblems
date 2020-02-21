package leetcode.test0151to0200;

public class Leetcode162 {
	public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length;
        
        while(start<end) {
        	int mid = (start+end)/2;
        	
        	if(mid-1<0 || mid+1>=nums.length) {
        		break;
        	}
        	if(nums[mid-1]<nums[mid] && nums[mid+1]<nums[mid]) {
        		return mid;
        	}
        	
        	if(nums[mid-1]<nums[mid] && nums[mid+1]>nums[mid]) {
        		start = mid;
        	}
        	
        	if(nums[mid-1]>nums[mid] && nums[mid+1]<nums[mid]) {
        		end = mid;
        	}
        	
        	if(nums[mid-1]>nums[mid] && nums[mid+1]>nums[mid]) {
        		end = mid;
        	}
        }

        if(start+1 != end){
            return nums[start]>nums[end-1] ? start : end-1;
        }
        
        return start;
    }
	
	
	public int findPeakElement2(int[] nums) {
		
		if(nums == null || nums.length == 0) {
			return -1;
		}
        int start = 0;
        int end = nums.length-1;
        
        while(start<end) {
        	int mid = (start+end)/2;
        	
        	if(mid+1>=nums.length) {
        		break;
        	}
        	if(nums[mid+1]<nums[mid]) {
        		end = mid;
        	}
        	
        	if(nums[mid+1]>nums[mid]) {
        		start = mid+1;
        	}
        }

        if(start != nums.length){
            return start;
        }
        
        return -1;
    }
}
/*
峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞。

示例 1:

输入: nums = [1,2,3,1]
输出: 2
解释: 3 是峰值元素，你的函数应该返回其索引 2。
示例 2:

输入: nums = [1,2,1,3,5,6,4]
输出: 1 或 5 
解释: 你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。
*/

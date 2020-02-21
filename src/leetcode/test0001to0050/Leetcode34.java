package leetcode.test0001to0050;

public class Leetcode34 {
	public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
        	return new int[]{-1,-1};
        }
        
        int start = 0;
        int end = nums.length - 1;
        
        while(start <= end) {
        	int mid = (start + end)/2;
        	if(nums[mid] == target) {
        		int left = mid;
        		int right = mid;
        		while(left-1 >= 0) {
        			if(nums[left -1] == target) {
        				left--;
        			}else {
        				break;
        			}
        		}
        		
        		while(right+1 < nums.length) {
        			if(nums[right + 1] == target) {
        				right++;
        			}else {
        				break;
        			}
        		}
        		
        		return new int[] {left,right};
        	}
        	if(nums[mid] > target) {
        		end = mid-1;
        	}
        	if(nums[mid] < target) {
        		start = mid + 1;
        	}
        }
        
        return new int[]{-1,-1};
    }
}
/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

你的算法时间复杂度必须是 O(log n) 级别。

如果数组中不存在目标值，返回 [-1, -1]。

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: [3,4]
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: [-1,-1]
*/

package leetcode.test0001to0050;

public class Leetcode33 {
	public int search(int[] nums, int target) {
		int min = 0;
		int max = nums.length-1;
		
		while(min<max) {
			int mid = (min+max)>>>1;
			if(nums[mid] == target) {
				return mid;
			}
			if(nums[mid] > nums[min]) {
				if(nums[mid] > target && target >= nums[min]) {
					max = mid -1;
					break;
				}else {
					min = mid + 1;
				}
			}else {
				if(nums[mid+1] <= target && target <= nums[max]) {
					min = mid + 1;
					break;
				}else {
					max = mid - 1;
				}
			}
		}
		
		while(min <= max) {
			int m = (min+max)>>>1;
			if(nums[m] == target) {
				return m;
			}else if(nums[m] > target){
				max = m - 1;
			}else{
				min = m + 1;
			}	
		}
        return -1;
    }
}
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。

你可以假设数组中不存在重复的元素。

你的算法时间复杂度必须是 O(log n) 级别。

示例 1:

输入: nums = [4,5,6,7,0,1,2], target = 0
输出: 4
示例 2:

输入: nums = [4,5,6,7,0,1,2], target = 3
输出: -1
*/

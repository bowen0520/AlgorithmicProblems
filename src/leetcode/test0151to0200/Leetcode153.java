package leetcode.test0151to0200;

public class Leetcode153 {
	public int findMin(int[] nums) {
		if(nums.length==0) {
			return 0;
		}
		int min = 0;
		int max = nums.length-1;
		if (nums.length == 1||nums[0] < nums[max]) {
            return nums[0];
        }
		while(min<max) {//二分法
			int mid = (max+min)/2+1;
			if(nums[mid+1]<nums[mid]) {
				return nums[mid+1];
			}
			if(nums[mid]>nums[0]) {
				min = mid;
			}else if(nums[mid]<nums[0]){
				max = mid;
			}else {
				//特殊情况
				//2,1,2,2,2,2,2,2
				//2,2,2,2,2,2,1,2
				//所以相等时只能让max--
				max--;
			}
		}
		return nums[min];
    }
	
	
	public int findMin2(int[] nums) {
		if(nums.length==0) {
			return 0;
		}
		int min = 0;
		int max = nums.length;
		if (nums.length == 1||nums[0] < nums[max-1]) {
            return nums[0];
        }
		while(min<max) {//二分法
			int mid = (max+min)/2;
            if(mid+1>=nums.length){
                break;
            }

			if(nums[mid+1]<nums[mid]) {
				return nums[mid+1];
			}
			if(nums[mid]>nums[0]) {
				min = mid+1;
			}else if(nums[mid]<nums[0]){
				max = mid;
			}else {
				//特殊情况
				//2,1,2,2,2,2,2,2
				//2,2,2,2,2,2,1,2
				//所以相等时只能让max--
				max--;
			}
		}

        if(min-1!=max) {
			return Math.min(nums[min], nums[max-1]);
		}

		return nums[min];
    }
}
/*
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

你可以假设数组中不存在重复元素。

示例 1:

输入: [3,4,5,1,2]
输出: 1
示例 2:

输入: [4,5,6,7,0,1,2]
输出: 0
*/

package leetcode.test151to200;

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
}

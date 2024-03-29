package leetcode.test0001to0050;

public class Leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int sum = nums1.length+nums2.length;
    	
    	int[] newArr = new int[sum];
    	
    	//int i = 0;
		//int j = 0;
		for(int an = 0,i = 0,j = 0;an<sum;an++){
			if(i >= nums1.length) {
				newArr[an] = nums2[j++];
			}else if(j >= nums2.length) {
				newArr[an] = nums1[i++];
			}else if(nums1[i] < nums2[j]) {
				newArr[an] = nums1[i++];
			}else {
				newArr[an] = nums2[j++];
			}
		}
    	if(sum%2 == 1) {
    		return (double)newArr[sum/2];
    	}else {
    		return ((double)newArr[sum/2 - 1] + (double)newArr[sum/2])/2;
    	}
    }
}
/*
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
*/

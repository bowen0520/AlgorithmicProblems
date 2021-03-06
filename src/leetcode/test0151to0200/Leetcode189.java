package leetcode.test0151to0200;

import java.util.Arrays;

public class Leetcode189 {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8};
		new Leetcode189().rotate(nums, 4);
		System.out.println(Arrays.toString(nums));
	}
	
	public void rotate(int[] nums, int k) {
		k = k%nums.length;
		fz(nums,0,nums.length-1);
		fz(nums,0,k-1);
		fz(nums,k,nums.length-1);
	}
	
	public void fz(int[] nums,int start,int end) {
		while(start<end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	/*public void rotate(int[] nums, int k) {
		int len = nums.length;
		if(len <= 1) {
			return ;
		}
		k = k%len;
		if(k == 0) {
			return ;
		}
		int count = 0;
		for(int i = 0;count<len;i++) {
			int books = nums[i];
			int index = i;
			do {
				index = (index+k)%len;
				int temp = nums[index];
				nums[index]=books;
				books = temp;
				count++;
			}while(index!=i);
		}
	}*/
	
	
	/*public void rotate(int[] nums, int k) {
		int len = nums.length;
		if(len<=1) {
			return ;
		}
	    int count = k%len;
	    
	    for(int i = 0;i<count;i++) {
	    	int temp = nums[0];
	    	for(int j = 1;j<len;j++) {
	    		int book = nums[j];
	    		nums[j] = temp;
	    		temp = book;
	    	}
	    	nums[0] = temp;
	    }
	}*/
}
/*
给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

示例 1:

输入: [1,2,3,4,5,6,7] 和 k = 3
输出: [5,6,7,1,2,3,4]
解释:
向右旋转 1 步: [7,1,2,3,4,5,6]
向右旋转 2 步: [6,7,1,2,3,4,5]
向右旋转 3 步: [5,6,7,1,2,3,4]
示例 2:

输入: [-1,-100,3,99] 和 k = 2
输出: [3,99,-1,-100]
解释: 
向右旋转 1 步: [99,-1,-100,3]
向右旋转 2 步: [3,99,-1,-100]
说明:

尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
要求使用空间复杂度为 O(1) 的 原地 算法。
*/
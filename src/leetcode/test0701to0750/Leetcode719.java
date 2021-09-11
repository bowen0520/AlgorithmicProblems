package leetcode.test0701to0750;

import java.util.Arrays;

public class Leetcode719 {
    public int smallestDistancePair(int[] nums, int k) {
    	int[] arr = new int[1000000];
    	
    	for(int i = 0;i<nums.length -1;i++) {
    		for(int j = i+1;j<nums.length;j++) {
    			arr[Math.abs(nums[i] - nums[j])]++;
    		}
    	}
    	
    	int sum = 0;
    	
    	for(int i = 0;i<arr.length;i++) {
    		sum += arr[i];
    		if(sum>=k) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);

        int lo = 0;
        int hi = nums[nums.length - 1] - nums[0];
        while (lo < hi) {
            int mi = (lo + hi) / 2;
            int count = 0, left = 0;
            for (int right = 0; right < nums.length; ++right) {
                while (nums[right] - nums[left] > mi) left++;
                count += right - left;
            }
            //count = number of pairs with distance <= mi
            if (count >= k) hi = mi;
            else lo = mi + 1;
        }
        return lo;
    }
}
/*
给定一个整数数组，返回所有数对之间的第 k 个最小距离。一对 (A, B) 的距离被定义为 A 和 B 之间的绝对差值。

示例 1:

输入：
nums = [1,3,1]
k = 1
输出：0 
解释：
所有数对如下：
(1,3) -> 2
(1,1) -> 0
(3,1) -> 2
因此第 1 个最小距离的数对是 (1,1)，它们之间的距离为 0。
提示:

2 <= len(nums) <= 10000.
0 <= nums[i] < 1000000.
1 <= k <= len(nums) * (len(nums) - 1) / 2.
*/

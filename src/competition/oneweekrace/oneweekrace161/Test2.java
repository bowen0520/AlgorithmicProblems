package competition.oneweekrace.oneweekrace161;

import java.util.HashSet;
import java.util.Set;

public class Test2 {
	/*public int numberOfSubarrays(int[] nums, int k) {
		int start = 0;
		int num = 0;
		int count = 0;
	    for(int i = 0;i<nums.length;i++) {
	    	if(nums[i]%2==1) {
	    		num++;
	    	}else {
	    		if(num==k) {
	        		count++;
	        	}
	    	}
	    }
	    return count;
	}*/
	
	
	public int numberOfSubarrays(int[] nums, int k) {
		int[] books = new int[nums.length];
	    for(int i = 0;i<nums.length;i++) {
	    	if(i==0) {
	    		books[i] = nums[i]%2==1?1:0;
	    	}else {
	    		books[i] = books[i-1]+(nums[i]%2==1?1:0);
	    	}
	    }
	    if(books[nums.length-1]<k) {
	    	return 0;
	    }
	    Set<int[]> set = new HashSet<int[]>();
	    for(int start = 0;start<nums.length-1;start++) {
	    	for(int end = 1;end<nums.length-1;end++) {
	    		int n = books[end]-books[start]+(nums[start]%2==1?1:0);
	    		if(n==k) {
	    			int[] temp = new int[end-start+1];
	    			for(int q = 0;q<temp.length;q++) {
	    				temp[q] = nums[q+start];
	    			}
	    			set.add(temp);
	    		}
	    	}
	    }
	    return set.size();
	}
}
/*
给你一个整数数组 nums 和一个整数 k。

如果某个子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。

请返回这个数组中「优美子数组」的数目。

 

示例 1：

输入：nums = [1,1,2,1,1], k = 3
输出：2
解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
示例 2：

输入：nums = [2,4,6], k = 1
输出：0
解释：数列中不包含任何奇数，所以不存在优美子数组。
示例 3：

输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
输出：16
 

提示：

1 <= nums.length <= 50000
1 <= nums[i] <= 10^5
1 <= k <= nums.length
*/
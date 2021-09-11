package leetcode.test0001to0050;

public class Leetcode45 {
    public int jump(int[] nums) {
    	int num = 0;
    	int temp = 0;
    	int step = 0;
        for(int i = 1;i<nums.length;i++) {
        	if(num + nums[num] >= nums.length-1) {
        		return step + 1;
        	}
        	
        	
        	if(i > num + nums[num]) {
        		step ++;
        		num = temp;
        	}
        	
        	if(i + nums[i] >temp + nums[temp]) {
    			temp = i;
    		}
        }
        
        return -1;
    }
}

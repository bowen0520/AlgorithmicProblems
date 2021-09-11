package leetcode.test0601to0650;

import java.util.Arrays;

public class Leetcode611 {
	
	public static void main(String[] args) {
		triangleNumber(new int[] {4,2,3,4});
	}
	
    public static int triangleNumber(int[] nums) {
        int an = 0;
        
        Arrays.sort(nums);
        
        for(int i = nums.length - 1; i >= 0; i--) {
        	int start = 0;
        	int end = i - 1;
        	
        	for(;start < end; ) {
        		if(nums[start] == 0) {
        			start++;
        			continue;
        		}
        		
        		while(end > start && nums[start] + nums[end] <= nums[i]) {
                    
        			start++;
        		}
        		
        		an = an + end - start;
        		end--;
        		
        	}
        	System.out.println(an);
        }
        
        return an;
    }
	
    public static int triangleNumber2(int[] nums) {
        int an = 0;
        
        Arrays.sort(nums);
        
        for(int i = nums.length - 1; i >= 0; i--) {
        	int start = 0;
        	int end = i - 1;
        	
        	int temp = end;
            boolean flag = true;
        	
        	for(;start < temp; start++) {
        		if(nums[start] == 0) {
        			continue;
        		}
        		
        		while(end > start && nums[start] + nums[end] > nums[i]) {
                    if(flag){
                        temp = end;
                        flag = false;
                    }
        			end--;
        		}
        		if(end > start){
                    an = an + temp - end;
                }else{
                    an = an + temp - start;
                }
        		
        	}
        	System.out.println(an);
        }
        
        return an;
    }
}

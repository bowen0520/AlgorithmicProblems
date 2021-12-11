package leetcode.test1001to1050;

import java.util.Arrays;

public class Leetcode1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
    	sort(nums);
    	int an = 0;
    	int min = Integer.MAX_VALUE;
    	for(int i = 0; i < nums.length; i++) {
    		int abs = Math.abs(nums[i]);
    		if(abs < min) {
    			min = abs;
    		}
    		
    		if(k > 0) {
    			if(nums[i] < 0) {
    				an = an - nums[i];
    				k--;
    			}else {
    				an = an + nums[i];
					if(k%2 != 0) {
						an = an - min * 2;
					}
					k = 0;
				}
    		}else {
    			an = an + nums[i];
			}
    	}
    	if(k > 0 && k%2 != 0) {
            an = an - min * 2;
        }
    	return an;
    }
	
	public void sort(int[] arr) {
		if(arr.length <= 1) {
			return;
		}
		int mid = arr.length / 2;
		int[] befer = Arrays.copyOfRange(arr, 0, mid);
		int[] after = Arrays.copyOfRange(arr, mid, arr.length);
		
		sort(befer);
		sort(after);
		
		int i = 0;
		int j = 0;
		int idx = 0;
		while(i < befer.length && j < after.length) {
			if(befer[i] <= after[j]) {
				arr[idx] = befer[i];
				idx++;
				i++;
			}else {
				arr[idx] = after[j];
				idx++;
				j++;
			}
		}
		
		while(i < befer.length) {
			arr[idx] = befer[i];
			idx++;
			i++;
			
		}
		
		
		while(j < after.length) {
			arr[idx] = after[j];
			idx++;
			j++;
		}
	}
}

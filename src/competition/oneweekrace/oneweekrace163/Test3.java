package competition.oneweekrace.oneweekrace163;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test3 {
	/*public int maxSumDivThree(int[] nums) {
	    return maxSumDivThree(nums, 0, 0, 0);
	}
	
	public int maxSumDivThree(int[] nums,int index, int sumOK,int sumNot) {
	    if(index == nums.length) {
	    	if(sumNot%3==0) {
	    		sumOK += sumNot;
	    	}
	    	return sumOK;
	    }
	    
	    if(sumNot%3==0) {
	    	sumOK += sumNot;
	    	sumNot = 0;
	    }
	    int an = 0;
	    
	    if(nums[index]%3==0) {
	    	an = maxSumDivThree(nums, index+1, sumOK+nums[index], sumNot);
	    }else {
	    	int x = maxSumDivThree(nums, index+1, sumOK, sumNot);
	    	int y = maxSumDivThree(nums, index+1, sumOK, sumNot+nums[index]);
	    	an = Math.max(x, y);
	    }
	    return an;
	}*/
	
	public int maxSumDivThree(int[] nums) {
	    List<Integer> list1 = new ArrayList<Integer>();
	    List<Integer> list2 = new ArrayList<Integer>();
	    
	    int sum  = 0;
	    
	    for(int i = 0;i<nums.length;i++) {
	    	if(nums[i]%3==1) {
	    		list1.add(nums[i]);
	    	}else if(nums[i]%3==2) {
	    		list2.add(nums[i]);
	    	}
	    	sum += nums[i];
	    }
	    
	    Collections.sort(list1);
	    Collections.sort(list2);
	    
	    if(sum%3==0) {
	    	return sum;
	    }else if(sum%3==1) {
	    	int an = Integer.MAX_VALUE;
	    	if(list1.size()>0) {
	    		an = list1.get(0);
	    	}
	    	if(list2.size()>1) {
	    		an = Math.min(an, list2.get(0)+list2.get(1));
	    	}
	    	return sum -an;
	    }else {
	    	int an = Integer.MAX_VALUE;
	    	if(list1.size()>1) {
	    		an = list1.get(0)+list1.get(1);
	    	}
	    	if(list2.size()>0) {
	    		an = Math.min(an, list2.get(0));
	    	}
	    	return sum -an;
	    }
	}
}

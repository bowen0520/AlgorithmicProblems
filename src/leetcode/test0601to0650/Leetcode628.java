package leetcode.test0601to0650;
/*
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积
 */
public class Leetcode628 {
	int min1 = 0;
    int min2 = 0;
    int max1 = 0;
    int max2 = 0;
    int max3 = 0;
    int maxmin1 = Integer.MIN_VALUE;
    int maxmin2 = Integer.MIN_VALUE;
    int maxmin3 = Integer.MIN_VALUE;
    public int maximumProduct(int[] nums) {
        
        
        for(int n :nums) {
        	getMin(n);
			getMinMax(n);
			/*if(n>0) {
				getMax(n);
			}else {
				getMin(n);
				getMinMax(n);
			}*/
        }
        
        return Math.max(maxmin1 * maxmin2 * maxmin3, min1 * min2 * maxmin1);
		/*if(max1 == 0) {
			return maxmin1 * maxmin2 * maxmin3;
		}else {
			if(min1 * min2 >= max1 * max2) {
		    	return min1 * min2 * max1;
		    }else {
				return max1 * max2 * max3;
			}
		}*/
        
    }
    
    public void getMin(int n) {
    	if(n<min1) {
    		min2 = min1;
    		min1 = n;
    	}else if(n<min2) {
    		min2 = n;
    	}
    }
    
    public void getMinMax(int n) {
    	if(n>maxmin1) {
    		maxmin3 = maxmin2;
    		maxmin2 = maxmin1;
    		maxmin1 = n;
    	}else if(n>maxmin2) {
    		maxmin3 = maxmin2;
    		maxmin2 = n;
    	}else if(n>maxmin3) {
    		maxmin3 = n;
    	}
    }
    
    public void getMax(int n) {
    	if(n>max1) {
    		max3 = max2;
    		max2 = max1;
    		max1 = n;
    	}else if(n>max2) {
    		max3 = max2;
    		max2 = n;
    	}else if(n>max3) {
    		max3 = n;
    	}
	}
}

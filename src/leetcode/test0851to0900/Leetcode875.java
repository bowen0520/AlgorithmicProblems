package leetcode.test0851to0900;

public class Leetcode875 {
    public int minEatingSpeed(int[] piles, int h) {
    	if (h < piles.length) {
    		return -1;
    	}
    	
        long sum = 0;
        int max = 0;
        for(int i = 0; i < piles.length; i++) {
        	sum = sum + piles[i];
        	if(piles[i] > max) {
        		max = piles[i];
        	}
        }
        
        if (h == piles.length) {
    		return max;
    	}
        
        int start = (int)((sum + h - 1) / h);
        int end = max;
        int an = max;
        while(start < end) {
        	int mid = (end - start) / 2 + start;
        	int tmpH = 0;
        	for(int j = 0; j < piles.length; j++) {
        		tmpH = tmpH + (piles[j] + mid - 1) / mid;
        	}
        	if(tmpH <= h) {
        		end = mid;
        		an = mid;
        	}else{
        		start = mid + 1;
        	}
        }
        
        return an;
    }
}

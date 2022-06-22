package leetcode.test0901to0950;

public class Leetcode926 {
    public int minFlipsMonoIncr(String s) {
        int[] count1 = new int[s.length() + 1];
        
        int[] count0 = new int[s.length() + 1];
        
        for(int i = 0; i < s.length(); i++) {
        	int j = s.length() - i - 1;
        	
        	if(s.charAt(i) == '1') {
        		count1[i + 1] = count1[i] + 1;
        	}else {
        		count1[i + 1] = count1[i];
			}
        	
        	if(s.charAt(j) == '0') {
        		count0[j] = count0[j + 1] + 1;
        	}else {
        		count0[j] = count0[j + 1];
			}
        }
        int an = Integer.MAX_VALUE;
        for(int i = 0; i < count0.length; i++) {
        	int max = count0[i] + count1[i];
        	if(max < an) {
        		an = max;
        	}
        }
        
        return an;
    }
}

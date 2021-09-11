package leetcode.test0001to0050;

public class Leetcode38 {
    public String countAndSay(int n) {
    	String an = "1";
    	if(n == 1) {
    		return an;
    	}
    	
    	for(int i = 1;i<n;i++) {
    		int c = 1;
    		StringBuilder sb = new StringBuilder();
    		int j = 1;
    		for(;j<an.length();j++) {
    			if(an.charAt(j)==an.charAt(j-1)) {
    				c++;
    			}else {
    				sb.append(c).append(an.charAt(j-1));
    				c=1;
    			}
    		}
    		
    		sb.append(c).append(an.charAt(j-1));
    		an = sb.toString();
    	}
    	
    	return an;
    }
}

package leetcode.test0651to0700;

public class Leetcode678 {
    public boolean checkValidString(String s) {
    	char[] cs = s.toCharArray();
    	
    	int numQ = 0;
    	int numH = 0;
    	for(int i = 0; i < cs.length; i++) {
    		char start = cs[i];
    		char end = cs[cs.length - i - 1];
    		
    		if(start == ')') {
    			numQ--;
    		}else{
    			numQ++;
			}
    		
    		if(end == '('){
    			numH--;
    		}else{
    			numH++;
			}
    		
    		if(numQ < 0 || numH < 0) {
    			return false;
    		}
    	}
    	
    	return true;
    }
}

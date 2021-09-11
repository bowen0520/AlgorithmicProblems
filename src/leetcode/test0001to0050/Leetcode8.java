package leetcode.test0001to0050;

public class Leetcode8 {
    public int myAtoi(String str) {
    	long num = 0;
    	char[] cs = str.trim().toCharArray();
    	if(cs.length<=0){
            return 0;
        }
    	boolean flag = true;
    	long book = Integer.MAX_VALUE;
    	int i = 0;
    	if(cs[i] == '+' || cs[i] == '-') {
    		flag = cs[i] == '+'?true:false;
    		i++;
    	}
    	for(;i<cs.length;i++) {
    		if(cs[i] >= '0' && cs[i] <= '9') {
    			num = num*10 + cs[i] -'0';
    			if(num > book) {
    				return flag?Integer.MAX_VALUE:Integer.MIN_VALUE;
    			}
    		}else {
    			break;
    		}
    	}
    	return (int)(flag?num:-num);
    }
}

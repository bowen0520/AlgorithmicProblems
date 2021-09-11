package leetcode.test0001to0050;

public class Leetcode9 {
    public boolean isPalindrome(int x) {
    	if(x<0) {
    		return false;
    	}
    	int num = x;
    	int an = 0;
    	while(num != 0) {
    		an = an*10 + num%10;
    		num = num/10;
    	}
    	
    	return an==x;
    }
}

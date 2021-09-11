package leetcode.test0001to0050;

public class Leetcode13 {
    public int romanToInt(String s) {
    	int[] nums = new int[s.length()];
    	for(int i = 0;i<s.length();i++) {
    		nums[i] = getNum(s.charAt(i));
    	}
    	int sum = nums[nums.length-1];
    	
    	for(int j = 0;j<nums.length-1;j++) {
    		if(nums[j]<nums[j+1]) {
    			sum = sum - nums[j];
    		}else {
    			sum = sum + nums[j];
    		}
    	}
    	return sum;
    }
    
   
    
    public int getNum(char c) {
    	if(c == 'I') {
    		return 1;
    	}else if(c == 'V') {
    		return 5;
    	}else if(c == 'X') {
    		return 10;
    	}else if(c == 'L') {
    		return 50;
    	}else if(c == 'C') {
    		return 100;
    	}else if(c == 'D') {
    		return 500;
    	}else {
    		return 1000;
    	}
    }
}

/*
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
    */

package leetcode.test0051to0100;

public class Leetcode66 {
	/*public int[] plusOne(int[] digits) {
	    return plusOne(digits, digits.length-1);
	}
	public int[] plusOne(int[] digits,int i) {
	    if(i<0) {
	    	int[] newDig = new int[digits.length+1];
	    	newDig[0] = 1;
	    	for(int j = 0;j<digits.length;j++) {
	    		newDig[j+1]=digits[j];
	    	}
	    	return newDig;
	    }else {
	    	digits[i]+=1;
	    	if(digits[i]>=10) {
	    		digits[i] = 0;
	    		return plusOne(digits, i-1);
	    	}else {
	    		return digits;
	    	}
	    }
	}*/
	
	public int[] plusOne(int[] digits) {
		for(int i = digits.length-1;i>=0;i--) {
			digits[i]+=1;
	    	if(digits[i]>=10) {
	    		digits[i] = 0;
	    	}else {
	    		return digits;
	    	}
		}
		digits = new int[digits.length+1];
		digits[0] = 1;
        return digits;
    }
}
/*
给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。
示例 2:

输入: [4,3,2,1]
输出: [4,3,2,2]
解释: 输入数组表示数字 4321。
*/

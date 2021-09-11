package leetcode.test0351to0400;

public class Leetcode367 {
	
	public static void main(String[] args) {
		System.out.println(new Leetcode367().isPerfectSquare(5));
	}
	
	
    public boolean isPerfectSquare(int num) {
    	if(num<=0) {
    		return false;
    	}
    	
    	int start = 1;
    	int end = num;
    	
    	while(start <= end) {
    		int mid = (start + end)/2;
    		
    		System.out.println(start + " " + mid + " " + end);
    		if(num/mid == mid && num%mid == 0) {
    			return true;
    		}
    		
    		if(num/mid == mid && num%mid != 0) {
    			start = mid + 1;
    		}
    		
    		if(num/mid > mid) {
    			start = mid + 1;
    		}
    		
    		if(num/mid < mid) {
    			end = mid - 1;
    		}
    	}
    	
    	return false;
    }
}
/*
给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。

说明：不要使用任何内置的库函数，如  sqrt。

示例 1：

输入：16
输出：True
示例 2：

输入：14
输出：False
*/

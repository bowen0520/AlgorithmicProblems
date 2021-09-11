package leetcode.test0001to0050;

import java.math.BigDecimal;

public class Leetcode50 {
	
	public static void main(String[] args) {
		System.out.println(new Leetcode50().myPow(8.88023,3));
		//8.88023,3	700.28148
		//2.00000,-2147483648 0.0
	}
	
	public double myPow(double x, int n) {
        if(x == 0) {
        	return 0.0;
        }
        if(n == 0) {
        	return 1;
        }
        
        long count = n;
        if(n<0) {
        	count = Math.abs((long)n);
        	x = 1/x;
        }

        double an = 1;
        double temp = x;
        
        long c = 0;
        while(c < count) {
        	if(c*2+1 > count) {
        		temp = x;
        		count = count-c;
        		c = 0;
        	}
        	
        	an *= temp;
        	temp *= temp;
        	c = c*2 + 1;
        }
        BigDecimal b = new BigDecimal(an);
        return b.setScale(5, BigDecimal.ROUND_DOWN).doubleValue();
    }
}
/*
实现 pow(x, n) ，即计算 x 的 n 次幂函数。

示例 1:

输入: 2.00000, 10
输出: 1024.00000
示例 2:

输入: 2.10000, 3
输出: 9.26100
示例 3:

输入: 2.00000, -2
输出: 0.25000
解释: 2-2 = 1/22 = 1/4 = 0.25
说明:

-100.0 < x < 100.0
n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。

*/

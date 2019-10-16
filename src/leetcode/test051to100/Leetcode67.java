package leetcode.test051to100;

import java.util.List;

public class Leetcode67 {
	/*public String addBinary(String a, String b) {
	    char[] as = a.toCharArray();
	    char[] bs = b.toCharArray();
	    
	    int ml = Math.max(as.length, bs.length);
	    int yu = 0;
	    int[] num = new int[ml];
	    for(int i = 0;i<ml;i++) {
	    	int geta = get(as.length-i-1,as);
	    	int getb = get(bs.length-i-1,bs);
	    	int sum = geta+getb+yu;
	    	num[i] = sum%2;
	    	yu = sum/2;
	    }
	    StringBuilder sb = new StringBuilder();
	    if(yu!=0) {
	    	sb.append(yu);
	    }
	    for(int i = num.length-1;i>=0;i--) {
	    	sb.append(num[i]);
	    }
	    return sb.toString();
	}*/
	
	public String addBinary(String a, String b) {
        char[] as = a.toCharArray();
        char[] bs = b.toCharArray();
        
        int ml = Math.max(as.length, bs.length);
        int yu = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<ml;i++) {
        	int geta = get(as.length-i-1,as);
        	int getb = get(bs.length-i-1,bs);
        	int sum = geta+getb+yu;
        	sb.insert(0, sum%2);
        	yu = sum/2;
        }
        
        if(yu!=0) {
        	sb.insert(0, yu);
        }
        return sb.toString();
    }
	public int get(int index,char[] arr) {
		if(index<0||index>=arr.length) {
			return 0;
		}
		return arr[index]-'0';
	}
}
/*
给定两个二进制字符串，返回他们的和（用二进制表示）。

输入为非空字符串且只包含数字 1 和 0。

示例 1:

输入: a = "11", b = "1"
输出: "100"
示例 2:

输入: a = "1010", b = "1011"
输出: "10101"
*/

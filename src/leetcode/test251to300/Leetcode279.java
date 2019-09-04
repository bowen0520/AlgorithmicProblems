package leetcode.test251to300;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Leetcode279 {
	public static void main(String[] args) {
		System.out.println(new Leetcode279().numSquares(12));
	}

	/*
	public int numSquares(int n) {
	    Queue<Integer> que = new ArrayDeque<Integer>();
	    Set<Integer> set = new HashSet<Integer>();
	    que.add(0);
	    int count = 0;
	    while(!que.isEmpty()) {
	    	int size = que.size();
	    	for(int i =0;i<size;i++) {
	    		int num = que.poll();
	    		if(num==n) {
	    			return count;
	    		}
	    		for(int j = 1;j*j+num<=n;j++) {
	    			if(!set.contains(j*j+num)) {
	    				que.add(j*j+num);
	    				set.add(j*j+num);
	    				System.out.println(j+"::"+num+"::"+(j*j+num));
	    			}
	    		}
	    	}
	    	count++;
	    }
	    return n;
	}
	*/
	//将set改成boolean数组更加节省空间，而且在判断的时候会加快
	public int numSquares(int n) {
        Queue<Integer> que = new ArrayDeque<Integer>();
        boolean[] books = new boolean[n+1];
        que.add(0);
        books[0] = true;
        int count = 0;
        while(!que.isEmpty()) {
        	int size = que.size();
        	for(int i =0;i<size;i++) {
        		int num = que.poll();
        		if(num==n) {
        			return count;
        		}
        		for(int j = 1;j*j+num<=n;j++) {
        			if(!books[j*j+num]) {
        				que.add(j*j+num);
        				books[j*j+num] = true;
        			}
        		}
        	}
        	count++;
        }
        return n;
    }
}
/*
给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9.

7168
*/
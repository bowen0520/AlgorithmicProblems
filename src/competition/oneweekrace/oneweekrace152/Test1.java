package competition.oneweekrace.oneweekrace152;

import java.util.Arrays;

public class Test1 {
	
	public static void main(String[] args) {
		Test1 t = new Test1();
		System.out.println(t.getNum(100));
		System.out.println(t.numPrimeArrangements(100));
	}
	
	
	public int numPrimeArrangements(int n) {
        int zs = getNum(n);
        int fzs = n-zs;
        return getAn(zs,fzs);
    }
    public int getNum(int n) {
    	boolean[] books = new boolean[n+1];
    	Arrays.fill(books, true);
    	books[0] = false;
    	books[1] = false;
    	int count = 0;
    	for(int i = 2;i<=n;i++) {
    		if(books[i]) {
    			count++;
    			for(int j = i*2;j<=n;j+=i) {
    				books[j] = false;
    			}
    		}
    	}
    	return count;
    }
    
    public int getAn(int a,int b) {
    	int min = Math.min(a, b);
    	int max = Math.max(a, b);
    	long n = 1;
    	for(int i = 2;i<=max;i++) {
    		if(i<=min) {
    			n =(n*i*i)%((int)(Math.pow(10, 9)+7));
    		}else {
    			n = (n*i)%((int)(Math.pow(10, 9)+7));
    		}
    	}
    	return (int)n;
    }
}
/*
请你帮忙给从 1 到 n 的数设计排列方案，使得所有的「质数」都应该被放在「质数的索引」上；你需要返回可能的方案总数。

让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。

由于答案可能会很大，所以请你返回答案 模 mod 10^9 + 7 之后的结果即可。

 

示例 1：

输入：n = 5
输出：12
解释：举个例子，[1,2,5,4,3] 是一个有效的排列，但 [5,2,3,4,1] 不是，因为在第二种情况里质数 5 被错误地放在索引为 1 的位置上。
示例 2：

输入：n = 100
输出：682289015
 

提示：

1 <= n <= 100
*/
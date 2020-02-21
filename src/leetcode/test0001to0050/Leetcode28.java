package leetcode.test0001to0050;

import java.util.HashSet;
import java.util.Set;

public class Leetcode28 {
	/*public int strStr(String haystack, String needle) {
		if(needle.length()==0) {
			return 0;
		}
		
		if(haystack.length()==0) {
			return -1;
		}
		
	    for(int i = 0;i<haystack.length();i++) {
	    	if(haystack.charAt(i)==needle.charAt(0)) {
	    		boolean flag = true;
	    		for(int j = 1;j<needle.length();j++) {
	    			if(j+i>=haystack.length()||haystack.charAt(i+j)!=needle.charAt(j)) {
	    				flag = false;
	    				break;
	    			}
	    		}
	    		if(flag) {
	    			return i;
	    		}
	    	}
	    }
	    return -1;
	}*/
	
	/*public int strStr(String haystack, String needle) {
		char[] as = haystack.toCharArray();
		char[] bs = needle.toCharArray();
		
		int al = as.length;
		int bl = bs.length;
		if(bl==0) {
			return 0;
		}
		if(al==0) {
			return -1;
		}
		
		Set<Character> books = new HashSet<Character>();
		
		for(int k = 0;k<bl;k++) {
			books.add(bs[k]);
		}
		
		for(int i = 0;i<al;i++) {
	    	if(as[i]==bs[0]) {
	    		int k = i;
	    		boolean flag = true;
	    		boolean bk = false;
	    		for(int j = 1;j<bl;j++) {
	    			if(i+j>=al) {
	    				return -1;
	    			}
	    			if(as[i+j]==bs[0]&&(!bk)) {
	    				k = i+j-1;
	    				bk = true;
	    			}else if(!bk){
	    				k++;
	    			}
	    			if(as[i+j]!=bs[j]) {
	    				if(!books.contains(as[i+j])) {
	    					k = i+j;
	    				}
	    				flag = false;
	    				break;
	    			}
	    		}
	    		if(flag) {
	    			return i;
	    		}
	    		i = k;
	    	}
	    }
	    return -1;
	}*/
	
	/*public int strStr(String haystack, String needle) {
	    int strLen = haystack.length(), subLen = needle.length();
	    if (subLen == 0) return 0;
	    if (strLen == 0) return -1;
	    // 构建状态机
	    int[][] FSM = new int[subLen][256];
	    int X = 0, matchChar = 0;
	    for (int i = 0; i < subLen; i++) {
	        matchChar = (int) needle.charAt(i);
	        for (int j = 0; j < 256; j++) {
	            // 当前状态 + 匹配失败字符 = 孪生词缀状态 + 匹配字符
	            FSM[i][j] = FSM[X][j]; 
	        }
	        FSM[i][matchChar] = i + 1;
	        if (i > 1) {
	            // 下一孪生前缀状态 = X + matchChar
	            X = FSM[X][matchChar];
	        }
	    }
	    // 匹配子串
	    int state = 0;
	    for (int i = 0; i < strLen; i++) {
	        state = FSM[state][haystack.charAt(i)];
	        if (state == subLen) {
	            return i - subLen + 1;
	        }
	    }
	    return -1;
	}*/
	public int strStr(String haystack, String needle) {
	    return new KMP(haystack).search(needle);
	}
	class KMP {
	    private int[][] dp;
	    private String pat;

	    public KMP(String pat) {
	        this.pat = pat;
	        int M = pat.length();
	        // dp[状态][字符] = 下个状态
	        dp = new int[M][256];
	        // base case
	        dp[0][pat.charAt(0)] = 1;
	        // 影子状态 X 初始为 0
	        int X = 0;
	        // 构建状态转移图（稍改的更紧凑了）
	        for (int j = 1; j < M; j++) {
	            for (int c = 0; c < 256; c++) {
	                dp[j][c] = dp[X][c];
	                dp[j][pat.charAt(j)] = j + 1;
	                // 更新影子状态
	                X = dp[X][pat.charAt(j)];
	            }
	        }
	    }

	    public int search(String txt) {
	        int M = pat.length();
	        int N = txt.length();
	        // pat 的初始态为 0
	        int j = 0;
	        for (int i = 0; i < N; i++) {
	            // 计算 pat 的下一个状态
	            j = dp[j][txt.charAt(i)];
	            // 到达终止态，返回结果
	            if (j == M) return i - M + 1;
	        }
	        // 没到达终止态，匹配失败
	        return -1;
	    }
	}

}


/*
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
*/

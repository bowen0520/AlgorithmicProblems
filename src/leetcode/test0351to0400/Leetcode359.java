package leetcode.test0351to0400;

public class Leetcode359 {
/*
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。

 

示例 1：

输入：s = "aaabb", k = 3
输出：3
解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
示例 2：

输入：s = "ababbc", k = 2
输出：5
解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 

提示：

1 <= s.length <= 104
s 仅由小写英文字母组成
1 <= k <= 105

 */
	
	
    public int longestSubstring(String s, int k) {
    	int[] countChar = new int[26];
    	
    	for(char c:s.toCharArray()) {
    		countChar[c-'a']++;
    	}
    	
    	int max = 0;
    	boolean flag = false;
    	String str = "";
    	
    	for(char c:s.toCharArray()) {
    		if(countChar[c-'a'] >= k) {
    			str = str + c;
    		}else {
				flag = true;
				int len = longestSubstring(str, k);
				if(len > max) {
					max = len;
				}
				str = "";
			}
    	}
    	
    	if(!flag) {
    		return s.length();
    	}
    	
    	if(str.length() > 0) {
    		int len = longestSubstring(str, k);
			if(len > max) {
				max = len;
			}
    	}
    	
    	
    	return max;
    }
}

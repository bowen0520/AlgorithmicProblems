package leetcode.test0401to0450;

import java.util.ArrayList;
import java.util.List;

public class Leetcode438 {
    public List<Integer> findAnagrams(String s, String p) {
    	List<Integer> list = new ArrayList<Integer>();
    	
    	if(s.length() < p.length()) {
    		return list;
    	}
    	
    	int[] sBook = new int[26];
    	int[] pBook = new int[26];
    	
    	for(int i = 0; i < p.length(); i++) {
    		sBook[s.charAt(i) - 'a']++;
    		pBook[p.charAt(i) - 'a']++;
    	}
    	if(anagramsEqs(sBook, pBook)) {
    		list.add(0);
    	}
    	
    	
    	for(int j = p.length(); j < s.length(); j++) {
    		sBook[s.charAt(j - p.length()) - 'a']--;
    		sBook[s.charAt(j) - 'a']++;
    		
    		if(anagramsEqs(sBook, pBook)) {
        		list.add(j - p.length() + 1);
        	}
    		
    	}
    	
    	return list;
    }
    
    
    public boolean anagramsEqs(int[] sBook, int[] pBook) {
    	
    	for(int i = 0; i < sBook.length; i++) {
    		if(sBook[i] != pBook[i]) {
    			return false;
    		}
    	}
    	
    	return true;
    }
    /*
     * 
     * 
     * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

 

示例 1:

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 示例 2:

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 

提示:

1 <= s.length, p.length <= 3 * 104
s 和 p 仅包含小写字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
}

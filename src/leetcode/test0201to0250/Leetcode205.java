package leetcode.test0201to0250;

import java.util.HashMap;
import java.util.Map;

public class Leetcode205 {
    public boolean isIsomorphic(String s, String t) {
    	char[] cs1 = s.toCharArray();
    	char[] cs2 = t.toCharArray();
    	
    	if(cs1.length==cs2.length) {
    		Map<Character,Character> map1 = new HashMap<Character, Character>();
    		
    		for(int i = 0;i < cs1.length;i++) {
    			if(map1.containsKey(cs1[i])) {
    				if(map1.get(cs1[i])!=cs2[i]) {
    					return false;
    				}
    			}else {
    				map1.put(cs1[i], cs2[i]);
    			}
    		}
    		
    		Map<Character,Character> map2 = new HashMap<Character, Character>();
    		
    		for(int i = 0;i < cs1.length;i++) {
    			if(map2.containsKey(cs2[i])) {
    				if(map2.get(cs2[i])!=cs1[i]) {
    					return false;
    				}
    			}else {
    				map2.put(cs2[i], cs1[i]);
    			}
    		}
    		return true;
    	}
    	
    	return false;
    }
}
/*
给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:

输入: s = "egg", t = "add"
输出: true
示例 2:

输入: s = "foo", t = "bar"
输出: false
示例 3:

输入: s = "paper", t = "title"
输出: true
说明:
你可以假设 s 和 t 具有相同的长度。
*/

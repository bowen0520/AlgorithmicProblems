package leetcode.test0351to0400;

import java.util.HashMap;
import java.util.Map;

public class Leetcode397 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        char[] cs = s.toCharArray();
        
        for(char c: cs) {
        	if(map.containsKey(c)) {
        		map.put(c,map.get(c)+1);
        	}else {
        		map.put(c, 1);
        	}
        }
        
        for(int i = 0;i<cs.length;i++) {
        	if(map.get(cs[i])==1) {
        		return i;
        	}
        }
        
        return -1;
    }
}
/*
给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

案例:

s = "leetcode"
返回 0.

s = "loveleetcode",
返回 2.
*/
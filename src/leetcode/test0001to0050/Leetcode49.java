package leetcode.test0001to0050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s:strs) {
        	
        	String ss = sortStr2(s);
        	if(map.containsKey(ss)) {
        		map.get(ss).add(s);
        	}else {
        		List<String> list = new ArrayList<String>();
        		list.add(s);
        		map.put(ss, list);
        	}
        }
        
        List<List<String>> lists = new ArrayList<List<String>>();
        
        map.forEach((k,v)->{
        	lists.add(v);
        });
        
        return lists;
    }
    
    public String sortStr(String str) {
    	char[] cs = str.toCharArray();
    	Arrays.sort(cs);
    	return new String(cs);
    }
    
    public String sortStr2(String str) {
    	char[] nums = new char[26];
    	
    	for(int i = 0;i<str.length();i++) {
    		nums[str.charAt(i)-'a']++;
    	}
    	
    	return new String(nums);
    }
}
/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
说明：

所有输入均为小写字母。
不考虑答案输出的顺序。
*/

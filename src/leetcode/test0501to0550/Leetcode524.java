package leetcode.test0501to0550;

import java.util.List;

public class Leetcode524 {
	public String findLongestWord(String s, List<String> dictionary) {
        dictionary.sort((a, b) -> { 
        	int len = b.length() - a.length();
        	return len == 0 ? a.compareTo(b) : len; 
    	});
        
        for(int i = 0; i < dictionary.size(); i++) {
        	char[] cs = dictionary.get(i).toCharArray();
        	int in = 0;
        	for(char c:s.toCharArray()) {
        		if(cs[in] == c) {
        			in++;
        		}
                if(in >= cs.length) {
        		    return dictionary.get(i);
        	    }
        	}
        		
        	if(in >= cs.length) {
        		return dictionary.get(i);
        	}	
        }
        return "";
    }
}
/*
给你一个字符串 s 和一个字符串数组 dictionary ，找出并返回 dictionary 中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。

如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。

 

示例 1：

输入：s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
输出："apple"
示例 2：

输入：s = "abpcplea", dictionary = ["a","b","c"]
输出："a"
 

提示：

1 <= s.length <= 1000
1 <= dictionary.length <= 1000
1 <= dictionary[i].length <= 1000
s 和 dictionary[i] 仅由小写英文字母组成

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
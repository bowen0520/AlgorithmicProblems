package leetcode.test0301to0350;

import java.util.HashMap;
import java.util.Map;

public class Leetcode318 {
	public int maxProduct(String[] words) {
		Map<String, boolean[]> map = new HashMap<String, boolean[]>();
		
		for(int i = 0; i < words.length; i++){
			boolean[] book = new boolean[26];

	        for(char c: words[i].toCharArray()){
	            book[c - 'a'] = true;
	        }
	        map.put(words[i], book);
        }
		
        int an = 0;
        for(int i = 0; i < words.length - 1; i++){
        	boolean[] book = map.get(words[i]);
        	int len = an / words[i].length();
            for(int j = i + 1; j < words.length; j++){
            	if(words[i].length() > len) {
	                if(checkCommonChar(book, words[j])){
	                    an = words[i].length() * words[j].length();
	                }
            	}
            }
        }

        return an;
    }

    public boolean checkCommonChar(boolean[] book, String b){

        for(char c: b.toCharArray()){
            if(book[c - 'a']){
                return false;
            }
        }

        return true;
    }
	
	
    public int maxProduct2(String[] words) {
        int an = 0;
        for(int i = 0; i < words.length - 1; i++){
            for(int j = i + 1; j < words.length; j++){
                if(checkCommonChar(words[i], words[j])){
                    an = Math.max(an, words[i].length() * words[j].length());
                }
            }
        }

        return an;
    }

    public boolean checkCommonChar(String a, String b){
        boolean[] book = new boolean[26];

        for(char c: a.toCharArray()){
            book[c - 'a'] = true;
        }

        for(char c: b.toCharArray()){
            if(book[c - 'a']){
                return false;
            }
        }

        return true;
    }
}
/*

给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。

 

示例 1:

输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
输出: 16 
解释: 这两个单词为 "abcw", "xtfn"。
示例 2:

输入: ["a","ab","abc","d","cd","bcd","abcd"]
输出: 4 
解释: 这两个单词为 "ab", "cd"。
示例 3:

输入: ["a","aa","aaa","aaaa"]
输出: 0 
解释: 不存在这样的两个单词。
 

提示：

2 <= words.length <= 1000
1 <= words[i].length <= 1000
words[i] 仅包含小写字母

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
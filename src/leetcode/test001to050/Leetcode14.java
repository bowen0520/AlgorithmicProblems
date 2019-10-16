package leetcode.test001to050;

public class Leetcode14 {
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0) {return "";}
		String an = strs[0];
        for(int i = 1;i<strs.length;i++) {
        	an = longestCommonPrefix(an.toCharArray(),strs[i].toCharArray());
        	if("".equals(an)){
        		return an;
        	}
        }
        return an;
    }
	
	public String longestCommonPrefix(char[] str1,char[] str2) {
		StringBuilder sb = new StringBuilder();
        int len = Math.min(str1.length, str2.length);
        for(int i = 0;i<len;i++) {
        	if(str1[i]==str2[i]) {
        		sb.append(str1[i]);
        	}else {
        		break;
        	}
        }
        return sb.toString();
    }
}
/*
编写一个函数来查找字符串数组中的最长公共前缀。

如果不存在公共前缀，返回空字符串 ""。

示例 1:

输入: ["flower","flow","flight"]
输出: "fl"
示例 2:

输入: ["dog","racecar","car"]
输出: ""
解释: 输入不存在公共前缀。
说明:

所有输入只包含小写字母 a-z 。
*/
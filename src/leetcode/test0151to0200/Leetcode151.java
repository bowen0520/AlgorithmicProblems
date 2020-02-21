package leetcode.test0151to0200;

public class Leetcode151 {
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		
		int end = s.length();
		boolean book = false;
		for (int i = end-1; i >= 0; i--) {
			if(s.charAt(i)==' '&&book) {
				sb.append(s.substring(i+1, end)).append(' ');
				end = i;
				book = false;
			}else if(s.charAt(i)!=' '&&!book){
				end = i+1;
				book = true;
			}
		}
		if(book) {
			return sb.append(s.substring(0, end)).toString();
		}else {
			return sb.length()==0?"":sb.substring(0, sb.length()-1);
		}
		
	}
	public static void main(String[] args) {
		System.out.println(new Leetcode151().reverseWords("  hello world!  "));
	}
}
/*
给定一个字符串，逐个翻转字符串中的每个单词。

示例 1：

输入: "the sky is blue"
输出: "blue is sky the"
示例 2：

输入: "  hello world!  "
输出: "world! hello"
解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
示例 3：

输入: "a good   example"
输出: "example good a"
解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

说明：

无空格字符构成一个单词。
输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
*/

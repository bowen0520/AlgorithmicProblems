package leetcode.test0351to0400;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode394 {
	public static void main(String[] args) {
		String s = "100[leetcode]";
		System.out.println(new Leetcode394().decodeString(s));
	}
	
	public String decodeString(String s) {
		Deque<Integer> deq = new ArrayDeque<Integer>();
		Deque<String> nums = new ArrayDeque<String>();
		int length = s.length();
		String num = "";
		for(int i = 0;i<length;) {
			char c = s.charAt(i);
			if(c=='[') {
				nums.push(num);
				num = "";
				deq.push(i);
				i++;
			}else if(c==']') {
				int x = deq.pop();
				String n = nums.pop();
				
				int start = x-n.length();
				
				int size = Integer.parseInt(n);
				String msg = s.substring(x+1, i);
				String newMsg = "";
				for(int k = 0;k<size;k++) {
					newMsg = newMsg + msg;
				}
				s = s.replace(s.substring(start,i+1), newMsg);
				i=start+newMsg.length();
				length = s.length();
			}else if(c>='0'&&c<='9'){
				num = num+c;
				i++;
			}else {
				i++;
			}
		}
		return s;
    }
}
/*
给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
*/

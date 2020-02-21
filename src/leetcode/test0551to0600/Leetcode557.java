package leetcode.test0551to0600;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode557 {
	/*public String reverseWords(String s) {
	    StringBuilder sb = new StringBuilder(s);
	    String str = sb.reverse().toString();
	    String[] strs = str.split(" ");
	    sb.setLength(0);
	    for(int i = strs.length-1 ; i >= 0 ; i--) {
	    	sb.append(strs[i]).append(" ");
	    }
	    return sb.substring(0, sb.length()-1);
	}*/
	
	public String reverseWords(String s) {
		if(s==null||s.length()<=0) {
			return s;
		}
	    StringBuilder sb = new StringBuilder();
	    char[] cs = s.toCharArray();
	    Queue<Deque<Character>> que = new LinkedList<Deque<Character>>();
	    Deque<Character> deq = new LinkedList<Character>();
	    for(char c:cs) {
	    	if(c!=' ') {
	    		deq.push(c);
	    	}else {
	    		que.offer(deq);
	    		deq = new LinkedList<Character>();
	    	}
	    }
	    que.offer(deq);
	    while(!que.isEmpty()) {
	    	deq = que.poll();
	    	while(!deq.isEmpty()) {
	    		sb.append(deq.pop());
	    	}
	    	sb.append(' ');
	    }
	    return sb.substring(0, sb.length()-1);
	}
	
	public static void main(String[] args) {
		
	}
}
/*
给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

示例 1:

输入: "Let's take LeetCode contest"
输出: "s'teL ekat edoCteeL tsetnoc" 
注意：在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格
*/

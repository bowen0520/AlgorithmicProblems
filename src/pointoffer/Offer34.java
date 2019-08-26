package pointoffer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Offer34 {
	public int FirstNotRepeatingChar(String str) {
        int[] books = new int[('z'-'a'+1)*2];
        Queue<Character> que = new LinkedList<Character>();
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        char[] cs = str.toCharArray();
        for(int i = 0;i<cs.length;i++) {
        	char c = cs[i];
        	int in = (c>='a'&&c<='z')?c-'a':c-'A'+26;
        	books[in]++;
        	if(!map.containsKey(c)) {
        		map.put(c,i);
        		que.offer(c);
        	}
        }
        while(!que.isEmpty()) {
        	char c = que.poll();
        	int i = (c>='a'&&c<='z')?c-'a':c-'A'+26;
        	if(books[i]==1) {
        		return map.get(c); 
        	}
        }
        return -1;
    }
	/*
	public int FirstNotRepeatingChar(String str) {
	    if(str.length()==0){
	        return -1;
	    }
	    HashSet<Character> log = new HashSet<>();
	    for(int i = 0;i<str.length();i++){
	        if(!log.contains(str.charAt(i))){
	            if(i==str.length()-1){
	                return i;
	            }
	            boolean flag = true;
	            for(int j = i+1;j<str.length();j++){
	                if(str.charAt(j)==str.charAt(i)){
	                    log.add(str.charAt(i));
	                    flag = false;
	                }
	            }
	            if(flag){
	                return i;
	            }
	        }
	    }
	    return -1;
	}*/
}
/*
题目描述
在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
*/
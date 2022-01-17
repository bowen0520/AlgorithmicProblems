package leetcode.test0851to0900;

import java.util.HashSet;
import java.util.Set;

public class Leetcode859 {
    public boolean buddyStrings(String s, String goal) {
        if(s.length() != goal.length()) {
        	return false;
        }
        int[] indexs = new int[2];
        int j = 0;
        Set<Character> book = new HashSet<Character>();
        boolean flag = false;
        for(int i = 0; i < s.length(); i++) {
        	
        	if(s.charAt(i) != goal.charAt(i)) {
        		if(j >= indexs.length) {
            		return false;
            	}
        		indexs[j] = i;
        		j++;
        	}else {
				if(book.contains(s.charAt(i))) {
					flag = true;
				}else {
					book.add(s.charAt(i));
				}
			}
        }
        if(j == 0 && flag) {
        	return true;
        }
        
        if(j == 2 && s.charAt(indexs[0]) == goal.charAt(indexs[1]) && s.charAt(indexs[0]) == goal.charAt(indexs[1])) {
        	return true;
        }
        
        return false;
    }
}

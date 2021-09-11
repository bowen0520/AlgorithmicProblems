package leetcode.test0001to0050;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {
    public List<String> generateParenthesis(int n) {
    	List<String> list = new ArrayList<String>();
    	generateParenthesis("", n, n, list);
    	return list;
    }
    
    public void generateParenthesis(String s, int q, int h, List<String> list) {
    	if(h == 0) {
    		list.add(s);
    		return ;
    	}
    	
    	if(q == 0) {
    		list.add(s + nChar(h));
    		return ;
    	}
    	generateParenthesis(new String(s + "("), q-1, h, list);
    	if(h>q) {
    		generateParenthesis(new String(s + ")"), q, h-1, list);
    	}
    }
    
    public String nChar(int n) {
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0;i < n;i++) {
    		sb.append("(");
    	}
    	return sb.toString();
    }
}

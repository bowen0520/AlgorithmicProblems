package leetcode.test0001to0050;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode10 {
	public static void main(String[] args) {
		String a = "aa";
		
		System.out.println(new Leetcode10().isMatch1("", "a*"));
		
		System.out.println("__" + a.substring(1, 1) + "--");
		
		//"a"
		//"ab*a"
		System.out.println(new Leetcode10().isMatch("a", "ab*a"));
	}
	
	Map<String, Boolean> map = new HashMap<String, Boolean>();
	
    public boolean isMatch(String s, String p) {
    	System.out.println(Arrays.toString(splits(p)));
    	return isMatch(s, 0, splits(p), 0);
    }
    public boolean isMatch(String s, int si, String[] p, int pi) {
    	String key = s+si+""+pi;
		/*if(map.containsKey(key)) {
			return map.get(key);
		}*/
    	if(si >= s.length() && pi >= p.length) {
    		return true;
    	}
    	
    	if(pi >= p.length) {
    		return false;
    	}
    	
    	if(si >= s.length()) {
    		return check(p, pi);
    	}
    	
    	for(int i = si;i<=s.length();i++) {
    		if(isMatch1(s.substring(si, i), p[pi])) {
    			if(isMatch(s, i, p, pi+1)) {
    				//map.put(key, true);
    				return true;
    			}
    		}else {
    			if(i!=si) {
    				break;
    			}
    		}
    	}
    	//map.put(key, false);
    	return false;
    	
    }
    
    public String[] splits(String p){
    	List<String> list = new ArrayList<String>();
    	for(int i = 0;i<p.length();) {
    		if(i+1<p.length() && p.charAt(i+1) == '*') {
    			list.add(p.substring(i, i+2));
    			i = i+2;
    		}else {
    			list.add(p.substring(i, i+1));
    			i = i+1;
    		}
    	}
    	
    	String[] ps = new String[list.size()];
    	
    	for(int i = 0;i<ps.length;i++) {
    		ps[i] = list.get(i);
    	}
    	return ps;
    }
    
    public boolean isMatch1(String s, String p) {
    	if(p.equals(".*")) {
    		return true;
    	}
    	if(s.equals(p)) {
    		return true;
    	}
    	if(p.equals(".") && s.length() == 1) {
    		return true;
    	}
    	
    	if(p.endsWith("*")) {
    		char c = p.charAt(0);
    		for(int i = 0;i<s.length();i++) {
    			if(s.charAt(i) != c) {
    				return false;
    			}
    		}
    		return true;
    	}
    	return false;
    } 
    
    public boolean check(String[] p, int pi) {
    	for(int i = pi;i<p.length;i++) {
    		if(!p[i].endsWith("*")) {
    			return false;
    		}
    	}
    	return true;
    }
} 

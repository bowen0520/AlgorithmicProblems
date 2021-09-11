package leetcode.test0001to0050;

import java.util.HashMap;
import java.util.Map;

public class Leetcode6 {
    public String convert(String s, int numRows) {
    	if(numRows <= 1) {
    		return s;
    	}
    	
    	Map<Integer, StringBuilder> map = new HashMap<Integer, StringBuilder>();
    	for(int m = 1;m<=numRows;m++) {
    		map.put(m, new StringBuilder());
    	}
    	
    	int i = 1;
    	boolean flag = true;
    	for(char c:s.toCharArray()) {
    		map.get(i).append(c);
    		if(i>=numRows) {
    			flag = false;
    		}
    		if(i<=1) {
    			flag = true;
    		}
    		i = i + (flag?1:-1);
    	}
    	StringBuilder sb = new StringBuilder();
    	
    	
    	for(int n = 1;n<=numRows;n++) {
    		sb.append(map.get(n));
    	}
    	return sb.toString();
    }
    
    public static void main(String[] args) {
		System.out.println(convert1("abaaab", 2));
	}
    
    
    public static String convert1(String s, int numRows) {
    	if(numRows <= 1) {
    		return s;
    	}
    	
    	StringBuilder[] sbs = new StringBuilder[numRows + 1];
    	
    	int i = 1;
    	boolean flag = true;
    	for(char c:s.toCharArray()) {
    		sbs[i].append(c);
    		if(i>=numRows) {
    			flag = false;
    		}
    		if(i<=1) {
    			flag = true;
    		}
    		i = i + (flag?1:-1);
    	}
    	StringBuilder sb = new StringBuilder();
    	
    	
    	for(int n = 1;n<=numRows;n++) {
    		sb.append(sbs[n]);
    	}
    	return sb.toString();
    }
    
    public String convert2(String s, int numRows) {

        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

}

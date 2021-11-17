package leetcode.test0451to0500;

import java.util.HashMap;
import java.util.Map;

public class Leetcode488 {
public static void main(String[] args) {
	System.out.println();
}
}

class MapSum {
	Map<String, Integer> map = new HashMap<String, Integer>();
	Map<String, Integer> book = new HashMap<String, Integer>();
    public MapSum() {

    }
    
    public void insert(String key, int val) {
    	
    	int old = book.getOrDefault(key, 0);
    	for (int i = 1; i <= key.length(); i++) {
    		String pre = key.substring(0, i);
    		
			map.put(pre, map.getOrDefault(pre, 0) - old + val);
		}
    	book.put(key, val);
    }
    
    public int sum(String prefix) {
    	return map.getOrDefault(prefix, 0);
    }
}

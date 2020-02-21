package leetcode.test0551to0600;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0;i<list1.length;i++) {
        	map.put(list1[i], i);
        }
        
        List<String> list = new ArrayList<String>();
        int minsum = list1.length+list2.length;
        for(int j = 0;j<list2.length&&j<=minsum;j++) {
        	if(map.containsKey(list2[j])) {
        		if(map.get(list2[j])+j==minsum) {
        			list.add(list2[j]);
        		}else if(map.get(list2[j])+j<minsum) {
        			minsum = map.get(list2[j])+j;
        			list.clear();
        			list.add(list2[j]);
        		}
        	}
        }
        
        return list.toArray(new String[list.size()]);
    }
}

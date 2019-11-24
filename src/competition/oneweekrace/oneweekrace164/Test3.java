package competition.oneweekrace.oneweekrace164;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test3 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> list = new ArrayList<String>();
        for(String s:products) {
        	list.add(s);
        }
        Collections.sort(list);
        
        List<List<String>> lists = new ArrayList<List<String>>();
        
        for(int i = 1;i<=searchWord.length();i++) {
        	List<String> temp = new ArrayList<String>();
        	String head = searchWord.substring(0, i);
        	for(int j = 0;j<list.size();j++) {
        		String str = list.get(j);
        		if(str.startsWith(head)) {
        			temp.add(str);
        		}
        		if(temp.size()>=3) {
        			break;
        		}
        	}
        	lists.add(temp);
        }
        return lists;
    }
}

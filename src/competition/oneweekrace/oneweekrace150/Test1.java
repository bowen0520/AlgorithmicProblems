package competition.oneweekrace.oneweekrace150;

import java.awt.Checkbox;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test1 {
	public int countCharacters(String[] words, String chars) {
		Map<Character, Integer> map = toMap(chars);
		int length = 0;
		for(String str:words) {
			if(check(str, map)) {
				length+=str.length();
			}
		}
		return length;
    }
	
	public Map<Character, Integer> toMap(String chars){
		char[] cs = chars.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(char c: cs) {
			if(map.containsKey(c)) {
				map.put(c,map.get(c)+1);
			}else {
				map.put(c, 1);
			}
		}
		return map;
	}
	
	public boolean check(String chars,Map<Character, Integer> map) {
		Map<Character,Integer> check = toMap(chars);
		Set<Character> set = check.keySet();
		Iterator<Character> iterator = set.iterator();
		while(iterator.hasNext()) {
			char c = iterator.next();
			if((!map.containsKey(c))||check.get(c)>map.get(c)) {
				return false;
			}
		}
		return true;
	}
}
/*
 * 
 * 
 * 
 * 
*/

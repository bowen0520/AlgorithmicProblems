package competition.oneweekrace.oneweekrace152;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test4 {
	public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		List<Integer> list = new ArrayList<Integer>();
		Set[] ss = new Set[words.length];
		for(int i = 0;i<words.length;i++) {
			Set<Character> set = new HashSet<Character>();
			char[] cs = words[i].toCharArray();
			for(char c:cs) {
				set.add(c);
			}
			ss[i] = set;
		}
		
		for(int j = 0;j<puzzles.length;j++) {
			int count = 0;
			char[] cs = puzzles[j].toCharArray();
			Set<Character> set = new HashSet<Character>();
			for(char c:cs) {
				set.add(c);
			}
			for(Set s:ss) {
				if(s.contains(cs[0])&&set.containsAll(s)) {
					count++;
				}
			}
			list.add(count);
		}
		return list;
    }
}

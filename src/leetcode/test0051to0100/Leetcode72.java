package leetcode.test0051to0100;

import java.util.HashMap;
import java.util.Map;

public class Leetcode72 {
	public int minDistance(String word1, String word2) {
		Map<String, Integer> book = new HashMap<String, Integer>();
		return minDistance(word1.toCharArray(), word2.toCharArray(), 0, 0, book);
    }
	
	public int minDistance(char[] cs1, char[] cs2, int index1, int index2, Map<String, Integer> book) {
		String key = index1 + " " + index2;
		if(book.containsKey(key)) {
			return book.get(key);
		}
		
		if(index2>=cs2.length) {
			return cs1.length-index1;
		}
		
		if(index1 >= cs1.length) {
			return cs2.length - index2;
		}
		
		if(cs1[index1] == cs2[index2]) {
			return minDistance(cs1, cs2, index1+1, index2+1, book);
		}
		
		int in = minDistance(cs1, cs2, index1, index2+1, book);
		int del = minDistance(cs1, cs2, index1+1, index2, book);
		int rep = minDistance(cs1, cs2, index1+1, index2+1, book);
		
		int an = Math.min(in, Math.min(del, rep)) + 1;
		
		book.put(key,an);
		
		return an;
	}
}

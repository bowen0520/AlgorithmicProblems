package leetcode.test0951t01000;

public class Leetcode953 {
    public boolean isAlienSorted(String[] words, String order) {
    	int[] wordsSort = new int[26];
    	for(int i = 0; i < order.length(); i++) {
    		wordsSort[order.charAt(i) - 'a'] = i;
    	}
    	
    	for(int i = 0; i < words.length - 1; i++) {
    		char[] an = getSort(words[i], words[i + 1]);
    		if(an[0] == '1') {
    			return false;
    		}else if(an[0] == '0') {
    			continue;
    		}else {
				if(wordsSort[an[0] - 'a'] > wordsSort[an[1] - 'a']) {
					return false;
				}
			}
    	}
    	return true;
    }
    
    public char[] getSort(String before, String after) {
    	int len = Math.min(before.length(), after.length());
    	
    	for(int i = 0; i < len; i++) {
    		if(before.charAt(i) != after.charAt(i)) {
    			return new char[] {before.charAt(i), after.charAt(i)};
    		}
    	}
    	
    	if(before.length() > after.length()) {
    		return new char[] {'1'};
    	}else {
			return new char[] {'0'};
		}
    }
    
}

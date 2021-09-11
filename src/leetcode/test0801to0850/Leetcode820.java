package leetcode.test0801to0850;

public class Leetcode820 {
    public int minimumLengthEncoding(String[] words) {
    	
    	int count = 1;
    	int len = words[0].length();
    	for(int i = 1;i<words.length;i++) {
    		boolean flag = true;
    		for(int j = 0;j<i;j++) {
    			if(words[i].endsWith(words[j])) {
    				len = len + words[i].length() - words[j].length();
    				words[j] = words[i];
    				flag = false;
    				break;
    			}else if(words[j].endsWith(words[i])) {
    				words[i] = words[j];
    				flag = false;
    				break;
    			}
    		}
    		if(flag) {
    			len += words[i].length();
    			count++;
    		}
    	}
    	return len + count;
    }
}

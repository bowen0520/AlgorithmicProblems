package leetcode.test0351to0400;

import java.util.Deque;
import java.util.LinkedList;

public class Leetcode388 {
	//   dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext
	public static void main(String[] args) {
		String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
		
		System.out.println(new Leetcode388().lengthLongestPath(input));
	}
	
    public int lengthLongestPath(String input) {
    	String[] inputs = input.split("\n");
    	
    	Deque<String> deque = new LinkedList<String>();
    	
    	int an = 0;
    	
    	int now = 0;
    	
    	int level = -1;
    	
    	for(int i = 0; i < inputs.length; i++) {
    		int nowLevel = getLevel(inputs[i]);
    		
    		System.out.println(inputs[i] + "  " + nowLevel);
    		if(nowLevel > level) {
    			now = now + inputs[i].length() + 1 - nowLevel;
    	    	level++;
    	    	
    		}else if (nowLevel == level) {
    			now = now - deque.pop().length() + inputs[i].length();
    			
			}else {
				while(nowLevel < level) {
					now = now - deque.pop().length() - 1 + level;
					level--;
				}
				now = now - deque.pop().length() + inputs[i].length();
			}
    		deque.push(inputs[i]);
    		if(inputs[i].indexOf(".") != -1 && now - 1 > an) {
	    		an = now - 1;
	    	}
    	}
    	return an;
    }
    
    public int getLevel(String input) {
    	int an = 0;
    	for(int i = 0; i < input.length(); i++) {
    		if("	".equals(input.substring(i, i+1))){
    			an++;
    		}else {
				break;
			}
    	}
    	
    	return an;
    }
}

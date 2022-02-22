package leetcode.test0801to0850;

public class Leetcode838 {
    public String pushDominoes2(String dominoes) {
        int idx = -1;
        char[] cs = dominoes.toCharArray();
        StringBuilder an = new StringBuilder();
        for(int i = 0; i < cs.length; i++){
            if(cs[i] == 'L'){
            	if(idx == -1) {
            		gotChar(an, i + 1, "L");
            	}else if(cs[idx] == 'R') {
            		
            		int len = i - idx + 1;
            		if(len%2 == 0) {
            			gotChar(an, len/2 - 1, "R");
            			gotChar(an, len/2, "L");
            		}else {
            			gotChar(an, len/2 - 1, "R");
            			gotChar(an, 1, ".");
            			gotChar(an, len/2, "L");
					}
            	}else {
            		gotChar(an, i - idx, "L");
				}
            	idx = i;
            }
            
            if(cs[i] == 'R'){
            	if(idx == -1) {
            		gotChar(an, i, ".");
            		gotChar(an, 1, "R");
            	}else if(cs[idx] == 'R') {
            		gotChar(an, i - idx, "R");
            	}else {
            		gotChar(an, i - idx - 1, ".");
            		gotChar(an, 1, "R");
				}
            	idx = i;
            }
            
        }
        
        if(idx == -1) {
    		gotChar(an, cs.length, ".");
    	}else if(cs[idx] == 'R') {
    		gotChar(an, cs.length - idx - 1, "R");
    	}else {
    		gotChar(an, cs.length - idx - 1, ".");
		}
        
        return an.toString();
    }

    public void gotChar(StringBuilder an, int length, String mino) {
        
        for(int i = 0; i < length; i++){
            an.append(mino);
        }
    }
    
    
    public String pushDominoes(String dominoes) {
        int idx = -1;
        char[] cs = dominoes.toCharArray();
        StringBuilder an = new StringBuilder();
        for(int i = 0; i < cs.length; i++){
        }
        
        if(idx == -1) {
    		gotChar(an, cs.length, ".");
    	}else if(cs[idx] == 'R') {
    		gotChar(an, cs.length - idx - 1, "R");
    	}else {
    		gotChar(an, cs.length - idx - 1, ".");
		}
        
        return an.toString();
    }
}

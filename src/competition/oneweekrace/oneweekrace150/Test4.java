package competition.oneweekrace.oneweekrace150;

public class Test4 {
	public String lastSubstring(String s) {
        int index = 0;
        char[] cs = s.toCharArray();
        for(int i = 1;i<cs.length;i++){
        	if(cs[i]>cs[index]) {
        		index = i;
        	}else if(cs[i]==cs[index]) {
        		for(int x = index+1;x<i;x++) {
        			if(i+x-index>=cs.length) {
        				break;
        			}
        			if(cs[x]>cs[i+x-index]) {
        				break;
        			}else if(cs[x]<cs[i+x-index]){
        				index = i;
        				break;
        			}
        		}
        	}
        }
        return s.substring(index);
    }
}

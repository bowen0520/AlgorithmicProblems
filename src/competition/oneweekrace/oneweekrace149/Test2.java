package competition.oneweekrace.oneweekrace149;

public class Test2 {
	public static void main(String[] args) {
		System.out.println(new Test2().maxRepOpt1("bbababaaaa"));
	}
	public int maxRepOpt1(String text) {
        char[] strs = text.toCharArray();
        int count = 1;
        int max = 1;
        for(int i = 1;i<strs.length;i++) {
        	if(strs[i]==strs[i-1]) {
        		count++;
        	}else {
        		if((i+1)<strs.length&&strs[i+1]==strs[i-1]) {
        			int temp = 0;
        			int j = i+1;
        			for(;j<strs.length;j++) {
        				if(strs[j]==strs[i-1]) {
        					temp++;
        				}else {
        					break;
        				}
        			}
        			int add = temp+count+(help(strs, i-count, j, strs[i-1])?1:0);
        			if(add>max) {
        				max = add;
        			}
        		}else {
        			int add = count+(help(strs, i-count, i, strs[i-1])?1:0);
        			if(add>max) {
        				max = add;
        			}
                    
        		}
        		count = 1;
        	}
        }
        
        return max;
    }
	public boolean help(char[] cs, int start,int end,char c) {
		for(int i = 0;i<start;i++) {
			if(cs[i]==c) {
				return true;
			}
		}
		for(int j = end+1;j<cs.length;j++) {
			if(cs[j]==c) {
				return true;
			}
		}
		return false;
	}
}

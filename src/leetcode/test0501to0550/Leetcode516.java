package leetcode.test0501to0550;

public class Leetcode516 {
    public int longestPalindromeSubseq(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int[][] map = new int[len + 1][len + 1];
        
        
        
        for(int i = len - 1; i >= 0; i--) {
        	for(int j = 1; j < len + 1; j++) {
            	if(cs[i] == cs[j]) {
            		map[i][j] = map[i+1][j-1] + 1;
            	}else {
					map[i][j] = Math.max(map[i+1][j], map[i][j-1]);
				}
            }
        }
        
        return map[0][len];
    }
}

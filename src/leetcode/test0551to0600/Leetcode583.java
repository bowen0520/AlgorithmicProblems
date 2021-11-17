package leetcode.test0551to0600;

public class Leetcode583 {
    public int minDistance(String word1, String word2) {
    	char[] ws1 = word1.toCharArray();
    	char[] ws2 = word2.toCharArray();
    	
        int[][] dp = new int[ws1.length + 1][ws2.length + 1];
        
        for(int i = 0; i < ws1.length; i++) {
        	for(int j = 0; j < ws2.length; j++) {
            	if(ws1[i] == ws2[j]) {
            		dp[i+1][j+1] = Math.max(dp[i][j], Math.max(dp[i+1][j], dp[i][j+1]));
            	}else {
            		dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
				}
            }
        }
        
        return ws1.length + ws2.length - dp[ws1.length][ws2.length] - dp[ws1.length][ws2.length];
    }
}
/*
给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。

 

示例：

输入: "sea", "eat"
输出: 2
解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
 

提示：

给定单词的长度不超过500。
给定单词中的字符只含有小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

*/
package competition.oneweekrace.oneweekrace164;

public class Test4 {
	public int numWays(int steps, int arrLen) {
        if(arrLen>steps) {
        	arrLen = steps;
        }
        long[] dp = new long[arrLen+2];
        dp[1] = 1;
        for(int i = 0;i<steps;i++) {
        	long[] ndp = new long[arrLen+2];
        	for(int j = 1;j<=arrLen;j++) {
        		ndp[j] = (dp[j]+dp[j-1]+dp[j+1])%(1000000000 + 7);
        	}
        	
        	dp = ndp;
        }
        
        return (int)dp[1];
    }
}

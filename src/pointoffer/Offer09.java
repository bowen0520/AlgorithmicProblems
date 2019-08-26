package pointoffer;

public class Offer09 {
	public int JumpFloorII(int target) {
        int[] count = new int[1];
        return JumpFloorII(target, count);
    }
	public int JumpFloorII(int target,int[] count) {
		if(target == 0) {
			count[0]++;
		}
		for(int i = 1;i<=target;i++) {
			JumpFloorII(target-i, count);
		}
		return count[0];
	}
	/*
	//因为它能够跳任意1到n的任意距离，所以对于除了第n块，其他的都可以选着跳到上面或者直接跳过
	public int JumpFloorII(int target) {
        int answer = 1;
        for(int i=1;i<target;i++){
            answer = answer*2;
        }
        return answer;
    }
	*/
	/*
	public int JumpFloorII(int target) {
        return (int)Math.pow(2,target-1);
    }
	*/
	/*
	public int JumpFloorII(int target) {
        if(target == 0) {
            return 0;
        }
          
        int[] dp = new int[target + 1];//存储跳到该下标台阶的可能次数
        dp[0] = 1;
        dp[1] = 1;
          
        for(int i = 2;i <= target;i++) {
            dp[i] = 0;
            for(int j = 0;j < i;j++) {//第i个台阶可能是从i-n个台阶直接跳n调过来的，所以只要将前面所有的次数相加即是答案
                dp[i] += dp[j];
            }
        }
          
        return dp[target];
    }
	*/
}

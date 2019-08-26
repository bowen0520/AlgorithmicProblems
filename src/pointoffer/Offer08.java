package pointoffer;

public class Offer08 {
	/*
	 * 跳n阶的次数是跳（n-1）阶的跳法加上（n-2）阶的跳法
	 * 因为跳n阶的时候最后一步可能是跳一下，也可能是跳2两下，所以只要知道跳n-1的次数，和n-2的次数
	 */
	public int JumpFloor(int target) {
		int[] nums = new int[target+1];
		return JumpFloor(target, nums);
		
    }
	public int JumpFloor(int target,int[] nums) {
		if(nums[target]!=0) {
			return nums[target];
		}
		if(target == 1) {
			return nums[1] = 1;
		}
		if(target == 2) {
			return nums[2] = 2;
		}
		return nums[target] = JumpFloor(target-1, nums)+JumpFloor(target-2, nums);
	}
}
/*
 * 题目描述 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
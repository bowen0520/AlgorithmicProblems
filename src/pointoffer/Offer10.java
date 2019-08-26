package pointoffer;

public class Offer10 {
	
	public int RectCover(int target) {//斐波拉契数列
		int[] nums = new int[target+1];
		return RectCover(target, nums);
    }
	public int RectCover(int target,int[] nums) {
		if(target < 3){
            return nums[target] = target;
        }
        if(nums[target]!=0) {
			return nums[target];
		}
		return nums[target] = RectCover(target-1, nums)+RectCover(target-2, nums);
	}
}
/*
 * 题目描述 
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
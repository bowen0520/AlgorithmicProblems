package pointoffer;

import java.util.Arrays;

import javax.print.attribute.standard.Finishings;

public class Offer07 {
	public static void main(String[] args) {
		System.out.println(new Offer07().Fibonacci(30));
	}
	
	
	static int[] nums = new int[40];
	/*
	public int Fibonacci(int n) {
		if(n == 0) {
			return nums[n];
		}
		nums[1] = 1;
		if(n == 1) {
			return nums[n];
		}
		for(int i = 2;i<=n;i++) {
			nums[i] = nums[i-1]+nums[i-2];
		}
		return nums[n];
    }
	*/
	public int Fibonacci(int n) {
		if(n==0) {
			return 0;
		}
		if(n==1) {
			nums[1] = 1;
			return 1;
		}
		if(nums[n]!=0) {
			return nums[n];
		}
		return nums[n] = Fibonacci(n-1)+Fibonacci(n-2);
    }
	
}
/*
 * 题目描述 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。 n<=39
 */

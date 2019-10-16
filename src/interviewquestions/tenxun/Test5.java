package interviewquestions.tenxun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
        for(int c = 0;c<n;c++){
            int len = sc.nextInt();
            int[] nums = new int[len];
            int sum = 0;
            for(int i = 0;i<len;i++) {
                int x = sc.nextInt();
                nums[i] = x;
                sum+=x;
            }
            int ban = len/2;
            System.out.println(ban);
            int a = help(nums,0,-1,ban);
            int b = sum-a;
            System.out.println(Math.min(a, b)+" "+Math.max(a, b));
        }
	}
	
	public static int help(int[] nums,int i,int index,int ban) {
		if(i==ban) {
			return nums[index];
		}
		int min = Integer.MAX_VALUE;
		for(int k = index+1;k<nums.length-ban+i+1;k++) {
			int a = help(nums,i+1,k,ban);
			if(a<min) {
				min = a;
			}
		}
		
		return i==0?min:min+nums[index];
	}
}

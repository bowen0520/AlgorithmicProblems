package pointoffer;

public class Offer33 {
	
	public int GetUglyNumber_Solution(int index) {
        if(index==0){
            return 0;
        }
        int[] nums = new int[index];
        nums[0]=1;
        int i2 = 0;int i3 = 0;int i5 = 0;
        int i = 1;
        while(i<index){
            int m2 = nums[i2]*2;
            int m3 = nums[i3]*3;
            int m5 = nums[i5]*5;
            nums[i] = Math.min(m2, Math.min(m3, m5));
            if(nums[i]==m2){i2++;}
            if(nums[i]==m3){i3++;}
            if(nums[i]==m5){i5++;}
            i++;
        }
        return nums[index-1];
    }
}
/*
题目描述
把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 
习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
*/
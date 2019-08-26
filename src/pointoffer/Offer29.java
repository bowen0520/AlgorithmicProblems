package pointoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class Offer29 {
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		//排序
		ArrayList<Integer> list = new ArrayList<Integer>();
		if(k>input.length) {
			return list;
		}
        Arrays.sort(input);
        int i = 0;
        while(k>0) {
        	list.add(input[i]);
        	k--;
        	i++;
        }
        return list;
    }
}
/*
题目描述
输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
*/
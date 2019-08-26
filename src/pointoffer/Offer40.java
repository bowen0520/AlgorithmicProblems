package pointoffer;

import java.util.HashSet;
import java.util.Set;

public class Offer40 {
	public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i:array) {
        	if(set.contains(i)) {
        		set.remove(i);
        	}else {
        		set.add(i);
        	}
        }
        boolean flag = false; 
        for(int o:set) {
        	if(!flag) {
        		num1[0] = o;
        		flag = true;
        	}else {
        		num2[0] = o;
        	}        	
        }
    }
}
/*
题目描述
一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
*/
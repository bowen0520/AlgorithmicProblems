package pointoffer;

import java.util.ArrayList;

public class Offer64 {
	public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(num==null||size<=0||num.length<size){
            return list;
        }
        int lastmax = num[0];
        for(int i=0;i<num.length-size+1;i++){
        	if(i-1>=0) {
	        	if(num[i-1]==lastmax&&num[i+size-1]>=lastmax) {
	        		lastmax = num[i+size-1];
	        		list.add(lastmax);
	        		continue;
	        	}
	        	
	        	if(num[i-1]!=lastmax) {
	        		lastmax = Math.max(lastmax, num[i+size-1]);
	        		list.add(lastmax);
	        		continue;
	        	}
        	}
        	
        	int max = num[i];
            for(int j=i+1;j<size+i;j++){
                if(num[j]>max) {
                	max = num[j];
                }
            }
            lastmax = max;
            list.add(max);
        }
        return list;
    }
}
/*
题目描述
给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 {[2,3,4],2,6,2,5,1}，
 {2,[3,4,2],6,2,5,1}，
 {2,3,[4,2,6],2,5,1}，
 {2,3,4,[2,6,2],5,1}，
 {2,3,4,2,[6,2,5],1}， 
 {2,3,4,2,6,[2,5,1]}。
*/
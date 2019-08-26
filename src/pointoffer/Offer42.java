package pointoffer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Offer42 {
	/*public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
		ArrayList<Integer> list = new ArrayList<Integer>();
	    int min = 0;
	    int max = array.length-1;
	    while(min<max) {
	    	if((array[min]+array[max])>sum) {
	    		max--;
	    	}else if((array[min]+array[max])<sum) {
	    		min++;
	    		max = array.length-1;
	    	}else {
	    		list.add(array[min]);
	            list.add(array[max]);
	            break;
	    	}
	    }
	    return list;
	}*/
	
	public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(array.length<=1){
            return list;
        }
        Deque<Integer> temp = new LinkedList<>();
        temp.push(array[0]);
        for(int i = 1;i<array.length;i++){
            if(array[i]+temp.peek()==sum){
                list.clear();
                list.add(0,temp.pop());
                list.add(1,array[i]);
            }
            if(array[i]+temp.peek()<sum){
                temp.push(array[i]);
            }
            if(array[i]+temp.peek()>sum){
                temp.pop();
                while(!temp.isEmpty()){
                    if(array[i]+temp.peek()==sum){
                        list.clear();
                        list.add(0,temp.pop());
                        list.add(1,array[i]);
                        break;
                    }
                    if(array[i]+temp.peek()<sum){
                        temp.push(array[i]);
                        break;
                    }
                    temp.pop();
                }
                if(temp.isEmpty()){
                    return list;
                }
            }
        }
        return list;
    }
}
/*
题目描述
输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
输出描述:
对应每个测试案例，输出两个数，小的先输出。
*/
package pointoffer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class Offer28 {
	static int a;
	
	public int MoreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        a = 0;
        for(int i:array) {
        	if(map.containsKey(i)) {
        		map.put(i, map.get(i)+1);
        	}else {
        		map.put(i, 1);
        	}
        }
       
        map.forEach((k,v)->{
        	if(a!=0) {
        		return;
        	}
        	if(v>array.length/2) {
        		a = k;
        	}
        });
        
        /*Set<Integer>set = map.keySet();
        Iterator<Integer> i = set.iterator();
        while(i.hasNext()) {
        	int k = i.next();
        	if(map.get(k)>array.length/2) {
        		return k;
        	}
        }*/
        return a;
    }
}
/*
题目描述
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
*/
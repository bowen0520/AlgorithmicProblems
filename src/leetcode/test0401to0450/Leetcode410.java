package leetcode.test0401to0450;

import java.util.HashMap;
import java.util.Map;

public class Leetcode410 {
    public int splitArray(int[] nums, int m) {
    	return splitArray(nums, 0, m);
    }
    
    Map<String, Integer> map = new HashMap<String, Integer>();
    
    public int splitArray(int[] nums, int start, int m) {
    	if(m == 1) {
    		int sum = 0;
    		for(int i = start;i<nums.length;i++) {
    			sum += nums[i];
    		}
    		map.put(start+" "+m, sum);
    		return sum;
    	}
    	
    	if(map.containsKey(start+" "+m)) {
    		return map.get(start+" "+m);
    	}
    	
    	int num = 0;
    	
    	int an = Integer.MAX_VALUE;
    	
    	for(int i = start;i<=nums.length-m;i++) {
    		num += nums[i];
    		String key = (i + 1) + " " + (m-1);
    		int max = 0;
    		if(map.containsKey(key)) {
    			max = map.get(key);
    		}else {
    			max = splitArray(nums, i+1, m-1);
    			map.put(key, max);
    		}
    		
    		int temp = Math.max(max, num);
    		
    		if(temp < an) {
    			an = temp;
    		}
    		
    		if(num >= max) {
    			break;
    		}
    	}
    	map.put(start+" "+m, an);
    	return an;
    }
}
/*
给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。设计一个算法使得这 m 个子数组各自和的最大值最小。

注意:
数组长度 n 满足以下条件:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
示例:

输入:
nums = [7,2,5,10,8]
m = 2

输出:
18

解释:
一共有四种方法将nums分割为2个子数组。
其中最好的方式是将其分为[7,2,5] 和 [10,8]，
因为此时这两个子数组各自的和的最大值为18，在所有情况中最小。
*/

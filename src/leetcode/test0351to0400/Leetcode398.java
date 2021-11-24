package leetcode.test0351to0400;

import java.util.HashMap;
import java.util.Map;

public class Leetcode398 {
	
	public static void main(String[] args) {
		System.out.println(2147483647 + 1);
		integerReplacement(2147483647);
	}
	
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public static int integerReplacement(int n) {
    	if(n == 1) {
    		return 0;
    	}
    	
    	if(map.containsKey(n)) {
    		return map.get(n);
    	}
    	int an = 0;
    	
    	while(n % 2 == 0) {
    		an = an + 1;
    		n = n/2;
    	}
    	
    	if(n != 1) {
    		an = an + 2 + Math.min(integerReplacement(n/2), integerReplacement(n/2 +1));
    	}
    	map.put(n, an);
    	return an;
    }
    
    public int integerReplacement2(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return 1 + integerReplacement(n / 2);
        }
        return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
    }
}

/*
 * 
 * 给定一个正整数 n ，你可以做如下操作：

如果 n 是偶数，则用 n / 2替换 n 。
如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
n 变为 1 所需的最小替换次数是多少？

 * 
 */

package leetcode.test1201to1250;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Leetcode2013 {
	/*
	给你一个在 X-Y 平面上的点构成的数据流。设计一个满足下述要求的算法：

	添加 一个在数据流中的新点到某个数据结构中。可以添加 重复 的点，并会视作不同的点进行处理。
	给你一个查询点，请你从数据结构中选出三个点，使这三个点和查询点一同构成一个 面积为正 的 轴对齐正方形 ，统计 满足该要求的方案数目。
	轴对齐正方形 是一个正方形，除四条边长度相同外，还满足每条边都与 x-轴 或 y-轴 平行或垂直。

	实现 DetectSquares 类：

	DetectSquares() 使用空数据结构初始化对象
	void add(int[] point) 向数据结构添加一个新的点 point = [x, y]
	int count(int[] point) 统计按上述方式与点 point = [x, y] 共同构造 轴对齐正方形 的方案数。

	*/
}

class DetectSquares {
	private Map<Integer, Map<Integer, Integer>> bookMap;
    public DetectSquares() {
    	bookMap = new HashMap<Integer, Map<Integer,Integer>>();
    }
    
    public void add(int[] point) {
    	if(bookMap.containsKey(point[0])) {
    		bookMap.get(point[0]).put(point[1], bookMap.get(point[0]).getOrDefault(point[1], 0) + 1);
    	}else {
			Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
			temp.put(point[1], 1);
			bookMap.put(point[0], temp);
		}
    }
    
    public int count(int[] point) {
    	int an = 0;
    	
    	Map<Integer, Integer> otherMap = bookMap.get(point[0]);
    	
    	if(otherMap == null) {
    		return 0;
    	}
    	for(Entry<Integer, Integer> node: otherMap.entrySet()) {
    		if(node.getKey() == point[1]) {
    			continue;
    		}
    		
    		int len = node.getKey() - point[1];
    		
    		int x1 = point[0] + len;
    		
    		int a = bookMap.getOrDefault(x1, new HashMap<Integer, Integer>()).getOrDefault(node.getKey(), 0);
    		int b = bookMap.getOrDefault(x1, new HashMap<Integer, Integer>()).getOrDefault(point[1], 0);
    		
    		
    		int x2 = point[0] - len;
    		int c = bookMap.getOrDefault(x2, new HashMap<Integer, Integer>()).getOrDefault(node.getKey(), 0);
    		int d = bookMap.getOrDefault(x2, new HashMap<Integer, Integer>()).getOrDefault(point[1], 0);
    		
    		an = an + node.getValue() * (a * b + c * d);
    		
    	}
    	
    	
    	return an;
    }
}


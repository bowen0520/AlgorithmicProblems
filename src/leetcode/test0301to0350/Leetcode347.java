package leetcode.test0301to0350;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode347 {
	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int n:nums) {
        	map.put(n,map.getOrDefault(n, 0)+1);
        }
        
        // init heap 'the less frequent element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));

        // keep k top frequent elements in the heap
        for (int n: map.keySet()) {
          heap.add(n);
          if (heap.size() > k)
            heap.poll();
        }

        // build output list
        List<Integer> top_k = new LinkedList<Integer>();
        while (!heap.isEmpty())
          top_k.add(heap.poll());
        Collections.reverse(top_k);
        return top_k;        
        
    }
	
	
	public List<Integer> topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int n:nums) {
        	map.put(n,map.getOrDefault(n, 0)+1);
        }
        
        List<Integer>[] books = new List[nums.length+1];
        
        for (int n: map.keySet()) {
          int count = map.get(n);
          if(books[count]==null)
          books[count] = new ArrayList<Integer>();
          
          books[count].add(n);
          
        }
        
        List<Integer> list = new ArrayList<Integer>();
        
        out : for(int i = books.length-1;i>=0;i--) {
        	
        	if(books[i]!=null) {
        		in : for(int n:books[i]) {
        			list.add(n);
        			if(list.size()>=k) {
                		break out;
                	}
        		}
        	}
        }
        
        return list;
    }
}
/*
给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
说明：

你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
*/

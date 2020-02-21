package leetcode.test0651to0700;

import java.util.ArrayList;
import java.util.List;

public class Leetcode659 {
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> list = new ArrayList<Integer>();
		if(arr == null || arr.length == 0) {
        	return list;
        }
        
        int start = 0;
        int end = arr.length - 1;
        
        while(start +1 < end) {
        	int mid = (start + end)/2;
        	if(arr[mid] == x || (x > arr[mid-1] && x < arr[mid + 1])) {
        		if(x>arr[mid]) {
        			if(x-arr[mid] > arr[mid + 1] - x) {
        				mid += 1;
        			}
        		}else {
        			if(x-arr[mid-1] <= arr[mid] -x) {
        				mid -= 1;
        			}
        		}
                
                if(k==1) {
        			list.add(arr[mid]);
        			return list;
        		}

                
        		
        		int left = mid;
        		int right = mid;
        		int num = 0;
        		
        		while(k > 1) {
        			if(left-1 >= 0 && arr[left -1] == x - num) {
        				left--;
        				k--;
        			}else if(right + 1 < arr.length && arr[right + 1] == x + num){
        				right++;
        				k--;
        			}else {
        				num++;
        			}
        		}
        		
        		for(int in = left;in <= right; in++) {
        			list.add(arr[in]);
        		}
        		
        		return list;
        	}
        	if(arr[mid] > x) {
        		end = mid;
        	}
        	if(arr[mid] < x) {
        		start = mid;
        	}
        }
        if(x<=arr[0]) {
        	for(int i = 0; i<k;i++) {
        		list.add(arr[i]);
        	}
        }else {
        	for(int i = arr.length-k; i<arr.length;i++) {
        		list.add(arr[i]);
        	}
        }
        return list;
    }
}
/*
给定一个排序好的数组，两个整数 k 和 x，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。如果有两个数与 x 的差值一样，优先选择数值较小的那个数。

示例 1:

输入: [1,2,3,4,5], k=4, x=3
输出: [1,2,3,4]
 

示例 2:

输入: [1,2,3,4,5], k=4, x=-1
输出: [1,2,3,4]
 

说明:

k 的值为正数，且总是小于给定排序数组的长度。
数组不为空，且长度不超过 104
数组里的每个元素与 x 的绝对值不超过 104
*/

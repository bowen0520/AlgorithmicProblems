package leetcode.test0301to0350;

import java.util.HashSet;
import java.util.Set;

public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
    	Set<Integer> set1 = new HashSet<Integer>();
        for(int n:nums1) {
        	set1.add(n);
        }
        return intersection(set1, nums2);
    }
    
    public int[] intersection(Set<Integer> set, int[] nums) {
    	Set<Integer> set2 = new HashSet<Integer>();
        for(int n:nums) {
        	if(set.contains(n)) {
        		set2.add(n);
        	}
        }
        int[] arr = new int[set2.size()];
        int i = 0;
        for(int n:set2) {
        	arr[i++] = n;
        }
        return arr;
    }
    
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        
        for(int num : nums1){
            s1.add(num);
        }
        
        for(int num : nums2){
            s2.add(num);
        }
        
        s1.retainAll(s2); // 2个set交集
        
        int[] res = new int[s1.size()];
        int k = 0;
        for(int num : s1){
            res[k++] = num;
        }

        return res;
    }
}
/*
给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [9,4]
说明:

输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序。
*/

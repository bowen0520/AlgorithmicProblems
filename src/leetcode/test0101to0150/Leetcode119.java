package leetcode.test0101to0150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode119 {
	/*
		public List<Integer> getRow(int rowIndex) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(1);
			if(rowIndex<1) {
				return list;
			}
			for(int i = 1;i<=rowIndex;i++) {
				for(int j = i-1;j>0;j--) {
					list.set(j,get(j-1,list)+get(j,list));
				}
				list.add(1);
			}
			return list;
	}
		public int get(int index,List<Integer> list) {
			if(index<0||index>=list.size()) {
				return 0;
			}
			return list.get(index);
		}
	*/
	
	//public static Map<int[], Integer> books = new HashMap<int[], Integer>();
	
	public List<Integer> getRow(int rowIndex) {
		long[] books = new long[rowIndex+1];
		getNum(books);
		
		System.out.println(Arrays.toString(books));
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<=rowIndex;i++) {
			int n = (int)(books[rowIndex]/(books[i]*books[rowIndex-i]));
			list.add(n);
		}
		return list;
    }
	public void getNum(long[] books) {
		long an = 1;
		for(int i = 0;i<books.length;i++) {
			books[i] = an;
			an = an*(i+1);
		}
	}

	public static void main(String[] args) {
		List<Integer> list = new Leetcode119().getRow(23);
		list.forEach(System.out::println);
	}
}
/*
给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
进阶：

你可以优化你的算法到 O(k) 空间复杂度吗？
Ckn = n!/(k!*(n-k)!)

1 1 2 6 24 120 720 
*/

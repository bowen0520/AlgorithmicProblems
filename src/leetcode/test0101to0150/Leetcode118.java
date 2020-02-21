package leetcode.test0101to0150;

import java.util.ArrayList;
import java.util.List;

public class Leetcode118 {
	/*public static void main(String[] args) {
		List<List<Integer>> lists = new Leetcode118().generate(5);
		for(List<Integer> list: lists) {
			for(int n: list) {
				System.out.print(n+" ");
			}
			System.out.println();
		}
	}*/
	
	public static void main(String[] args) {
        String s = "";
        StringBuilder sb = new StringBuilder();
        int n = 10000;
        
        long t1 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            s += "hello";
        }
        long t2 = System.nanoTime();
        for (int i = 0; i < n; i++) {
            sb.append("hello");
        }
        long t3 = System.nanoTime();
        System.out.println("string拼接"+(t2-t1));
        System.out.println("stringBuilder拼接"+(t3-t2));
    }
	
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if(numRows<1) {
			return lists;
		}
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		lists.add(list);
		for(int i = 1;i<numRows;i++) {
			List<Integer> temp = new ArrayList<Integer>();
			for(int j = 0;j<=i;j++) {
				temp.add(get(j-1,lists.get(i-1))+get(j,lists.get(i-1)));
			}
			lists.add(temp);
		}
		return lists;
    }
	public int get(int index,List<Integer> list) {
		if(index<0||index>=list.size()) {
			return 0;
		}
		return list.get(index);
	}
}
/*
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。



在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 5
输出:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
*/
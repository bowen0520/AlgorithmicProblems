package leetcode.test0051to0100;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<Integer>();
        if(matrix.length==0){
            return list;
        }
        
         int h = matrix.length;
         int w = matrix[0].length;
         int count = h >= w ? (w + 1) / 2 : (h + 1) / 2;
         for (int i = 0; i < count; i++) {
             int a,b,c,d;
             for(a=i;a<w-i;a++){
                 list.add(matrix[i][a]);
             }
             for(b = i+1;b<h-i;b++){
                 list.add(matrix[b][w-i-1]);
             }
             for(c = w-i-2;c>=i;c--){
                 if(i<h-i-1)
                 list.add(matrix[h-i-1][c]);
             }
             for(d = h-i-2;d>i;d--){
                 if(i<w-i-1)
                 list.add(matrix[d][i]);
             }
         }
         return list;
     }
}
/*
给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。

示例 1:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
输出: [1,2,3,6,9,8,7,4,5]
示例 2:

输入:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
输出: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

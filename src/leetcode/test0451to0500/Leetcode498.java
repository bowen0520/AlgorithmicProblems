package leetcode.test0451to0500;

public class Leetcode498 {
	public static void main(String[] args) {
		int[][] m = new int[][] {{1,2},{3,4}};
		new Leetcode498().findDiagonalOrder(m);
	}
	
	public int[] findDiagonalOrder(int[][] matrix) {
		if(matrix.length==0) {
			return new int[0];
		}
		
        int x = matrix.length;
        int y = matrix[0].length;
        
        int[] an = new int[x*y];
        int index = 0;
        
        int num = 0;
        boolean flag = false;
        
        for(int i = 0;i<x+y-1;i++) {
        	if(!flag) {
        		int n = i<x?i:x-1;
        		for(int j = n;j>=0&&i-j<y;j--) {
        			an[index++] = matrix[j][i-j];
        		}
        	}else {
        		int m = i<y?i:y-1;
        		for(int j = m;j>=0&&i-j<x;j--) {
        			an[index++] = matrix[i-j][j];
        		}
			}
        	flag = !flag;
        }
        return an;
    }
}
/*
给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。

示例:

输入:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

输出:  [1,2,4,7,5,3,6,8,9]

解释:s型读取

说明:

给定矩阵中的元素总数不会超过 100000 。
*/

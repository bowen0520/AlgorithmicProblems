package leetcode.test0501to0550;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode542 {
	private static final int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
	
	Queue<int[]> que = new ArrayDeque<int[]>(); 
	
	public int[][] updateMatrix(int[][] matrix) {	
		for(int i = 0;i<matrix.length;i++) {
			for(int j = 0;j<matrix[0].length;j++) {
				if(matrix[i][j]==0) {
					que.offer(new int[] {i,j});
				}else {
					matrix[i][j] = 10001;
				}
			}
		}
		
		while(!que.isEmpty()) {
			int n = que.size();
			for(int i = 0;i<n;i++) {
				int[] node = que.poll();
				updateMatrix(matrix, node[0], node[1]);
			}
		}
		
		return matrix;
    }
	
	public void updateMatrix(int[][] matrix,int x,int y) {
		int min = matrix[x][y];
		
		for(int i = 0;i<dir.length;i++) {
			int dx = x+dir[i][0];
			int dy = y+dir[i][1];
			if(x>=0&&x<matrix.length&&y>=0&&y<matrix[0].length) {
				min = Math.min(matrix[dx][dy]+1, min);
				
				if(matrix[dx][dy]==10001) {
					que.offer(new int[] {dx,dy});
				}
			}
		}
		
		matrix[x][y] = min;
	}
}

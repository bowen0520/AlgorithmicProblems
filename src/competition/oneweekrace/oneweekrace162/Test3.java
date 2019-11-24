package competition.oneweekrace.oneweekrace162;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test3 {
	public int closedIsland(int[][] grid) {
        int x = grid.length;
        int y = grid[0].length;
        boolean[][] books = new boolean[x][y];
        
        int count = 0;
        
        for(int i = 0;i<x;i++) {
        	for(int j = 0;j<y;j++) {
        		if(grid[i][j]==0&&!books[i][j]) {
        			if(isLend(i, j, grid, books)) {
        				count++;
        			}
        		}
        	}
        }
        return count;
    }
	
	public boolean isLend(int x,int y,int[][] grid,boolean[][] books) {
		boolean flag = true;
		books[x][y]=true;
		Deque<int[]> deq = new ArrayDeque<int[]>();
		int[] node = {x,y};
		deq.push(node);
		while(!deq.isEmpty()) {
			int[] index = deq.pop();
			int i = index[0];
			int j = index[1];
			if(i==0||i==grid.length-1||j==0||j==grid[0].length-1) {
				flag = false;
			}
			if(i+1<grid.length&&grid[i+1][j]==0&&!books[i+1][j]) {
				books[i+1][j] = true;
				deq.push(new int[] {i+1,j});
			}
			if(i-1>=0&&grid[i-1][j]==0&&!books[i-1][j]) {
				books[i-1][j] = true;
				deq.push(new int[] {i-1,j});
			}
			if(j+1<grid[0].length&&grid[i][j+1]==0&&!books[i][j+1]) {
				books[i][j+1] = true;
				deq.push(new int[] {i,j+1});
			}
			if(j-1>=0&&grid[i][j-1]==0&&!books[i][j-1]) {
				books[i][j-1] = true;
				deq.push(new int[] {i,j-1});
			}
		}
		return flag;
	}
}
/*
[
[0,0,1,1,0,1,0,0,1,0],
[1,1,0,1,1,0,1,1,1,0],
[1,0,1,1,1,0,0,1,1,0],
[0,1,1,0,0,0,0,1,0,1],
[0,0,0,0,0,0,1,1,1,0],
[0,1,0,1,0,1,0,1,1,1],
[1,0,1,0,1,1,0,0,0,1],
[1,1,1,1,1,1,0,0,0,0],
[1,1,1,0,0,1,0,1,0,1],
[1,1,1,0,1,1,0,1,1,0]
]
*/
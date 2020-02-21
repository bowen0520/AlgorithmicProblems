package leetcode.test0151to0200;

import java.util.ArrayDeque;
import java.util.Queue;

public class Leetcode200 {
	public static void main(String[] args) {
		char[][] grid = new char[0][];
		
		System.out.println(new Leetcode200().numIslands(grid));
	}
	
	public int numIslands(char[][] grid) {
		int x = grid.length;
        if(x==0){
            return 0;
        }
		int y = grid[0].length;
		int count = 0;
		boolean[][] books = new boolean[x][y];
		for(int i = 0;i<x;i++) {
			for(int j = 0;j<y;j++) {
				if(!books[i][j]&&grid[i][j]=='1') {
					count++;
					books[i][j] = true;
					bookLands(grid,i,j,books);
				}
			}
		}
        return count;
    }
	
	//bfs标记岛屿
	/*public void bookLands(char[][] grid,int x,int y,boolean[][] books) {
		Queue<int[]> que = new ArrayDeque<int[]>();
		int[] point = {x,y};
		books[x][y] = true;
		que.offer(point);
		while(!que.isEmpty()) {
			int[] p = que.poll();
			int i = p[0];
			int j = p[1];
	        
	        if(i+1<grid.length&&grid[i+1][j]=='1'&&!books[i+1][j]) {
				int[] np = {i+1,j};
	            books[i+1][j] = true;
				que.offer(np);
			}
			
			if(i-1>=0&&grid[i-1][j]=='1'&&!books[i-1][j]) {
				int[] np = {i-1,j};
	            books[i-1][j] = true;
				que.offer(np);
			}
			if(j+1<grid[0].length&&grid[i][j+1]=='1'&&!books[i][j+1]) {
				int[] np = {i,j+1};
	            books[i][j+1] = true;
				que.offer(np);
			}
			if(j-1>=0&&grid[i][j-1]=='1'&&!books[i][j-1]) {
				int[] np = {i,j-1};
	            books[i][j-1] = true;
				que.offer(np);
			}
		}
	}*/
	//dfs标记岛屿
	int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
	public void bookLands(char[][] grid,int x,int y,boolean[][] books) {
		for(int i = 0;i<dir.length;i++){
			int a = x+dir[i][0];
			int b = y+dir[i][1];
			if(a>=0&&a<grid.length&&b>=0&&b<grid[0].length&&grid[a][b]=='1'&&!books[a][b]) {
				books[a][b] = true;
				bookLands(grid, a, b, books);
			}
		}
	}
}
/*
给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。
你可以假设网格的四个边均被水包围。

示例 1:

输入:
11110
11010
11000
00000

输出: 1
示例 2:

输入:
11000
11001
00111
00011

输出: 3


[
["1","1","1","1","1","0","1","1","1","1","1","1","1","1","1","0","1","0","1","1"],
["0","1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","0"],
["1","0","1","1","1","0","0","1","1","0","1","1","1","1","1","1","1","1","1","1"],
["1","1","1","1","0","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
["1","0","0","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
["1","0","1","1","1","1","1","1","0","1","1","1","0","1","1","1","0","1","1","1"],
["0","1","1","1","1","1","1","1","1","1","1","1","0","1","1","0","1","1","1","1"],
["1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","0","1","1"],
["1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","1","1","1","1"],
["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
["0","1","1","1","1","1","1","1","0","1","1","1","1","1","1","1","1","1","1","1"],
["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
["1","1","1","1","1","0","1","1","1","1","1","1","1","0","1","1","1","1","1","1"],
["1","0","1","1","1","1","1","0","1","1","1","0","1","1","1","1","0","1","1","1"],
["1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","1","0"],
["1","1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","0","0"],
["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],
["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"]
]

输出：1
*/
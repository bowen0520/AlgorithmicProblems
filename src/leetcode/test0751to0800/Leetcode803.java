package leetcode.test0751to0800;


public class Leetcode803 {
	public int[] hitBricks(int[][] grid, int[][] hits) {
		
		countBricks(bookBricks(grid), grid);
		
		int[] an = new int[hits.length];
		
		for(int i = 0; i < hits.length; i++) {
			if(grid[hits[i][0]][hits[i][1]] == 0) {
				an[i] = 0;
			}else {
				grid[hits[i][0]][hits[i][1]] = 0;
				an[i] = countBricks(bookBricks(grid), grid);
			}
		}
		return an;
	}

	public int countBricks(boolean[][] book, int[][] grid) {
		int count = 0;
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(!book[i][j] && grid[i][j] == 1) {
					count++;
					grid[i][j] = 0;
				}
			}
		}
		return count;
	}

	public boolean[][] bookBricks(int[][] grid) {
		boolean[][] wen = new boolean[grid.length][grid[0].length];
		boolean[][] book = new boolean[grid.length][grid[0].length];

		for (int i = 0; i < grid[0].length; i++) {
			book[0][i] = true;
			if(grid[0][i] == 1) {
				wen[0][i] = true;
				remark(grid, wen, book, 0, i);
			}
		}
		return wen;
	}
	
	public void remark(int[][] grid, boolean[][] wen, boolean[][] book, int row, int list) {
		if(row - 1 >= 0 && !book[row-1][list]) {
			book[row - 1][list] = true;
			if(grid[row - 1][list] == 1) {
				wen[row - 1][list] = true;
				remark(grid, wen, book, row-1, list);
			}
		}
		
		if(row + 1 < grid.length && !book[row+1][list]) {
			book[row + 1][list] = true;
			if(grid[row + 1][list] == 1) {
				wen[row + 1][list] = true;
				remark(grid, wen, book, row+1, list);
			}
		}
		
		if(list - 1 >= 0 && !book[row][list - 1]) {
			book[row][list - 1] = true;
			if(grid[row][list - 1] == 1) {
				wen[row][list - 1] = true;
				remark(grid, wen, book, row, list-1);
			}
		}
		
		if(list + 1 < grid[0].length && !book[row][list + 1]) {
			book[row][list + 1] = true;
			if(grid[row][list + 1] == 1) {
				wen[row][list + 1] = true;
				remark(grid, wen, book, row, list + 1);
			}
		}
	}
}

package leetcode.test0801to0850;

public class Leetcode807 {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
    	int[] rowHight = new int[grid.length];
    	int[] columnHight = new int[grid[0].length];
    	
    	for(int i = 0; i < grid.length; i++) {
    		for(int j = 0; j < grid[0].length; j++) {
    			if(grid[i][j] > rowHight[i]) {
    				rowHight[i] = grid[i][j];
    			}
    			if(grid[i][j] > columnHight[j]) {
    				columnHight[j] = grid[i][j];
    			}
    		}
    	}
    	int an = 0;
    	for(int i = 0; i < grid.length; i++) {
    		for(int j = 0; j < grid[0].length; j++) {
    			an = an + Math.min(rowHight[i], columnHight[j]) - grid[i][j];
    		}
    	}
    	
    	return an;
    }
}

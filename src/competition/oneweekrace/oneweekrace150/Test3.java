package competition.oneweekrace.oneweekrace150;

import java.awt.Checkbox;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

public class Test3 {
	
	public static void main(String[] args) {
		int[][] grid = {{1,0,0},{0,0,0},{0,0,0}};
		System.out.println(new Test3().maxDistance(grid));
	}
	
	public int maxDistance(int[][] grid) {
		int n = grid.length;
        boolean[][][] books = new boolean[n*n][n][n];
        int max = -1;
        for(int i = 0;i<n*n;i++) {
        	int x = i/n;
        	int y = i%n;
        	if(grid[x][y]==0) {
        		Queue<int[]> queue = new LinkedList<int[]>();
        		int[] temp = {x,y,grid[x][y]};
        		queue.offer(temp);
        		int l = check(queue, books, grid, 0, i);
        		if(l == -1) {
        			return -1;
        		}
        		if(l>max) {
        			max = l;
        		}
        	}
        }
        return max;
    }
	
	public int check(Queue<int[]> queue,boolean[][][] books,int[][] grid,int count,int star) {
		int size = queue.size();
		if(size==0) {
			return -1;
		}
		for(int i = 0;i<size;i++) {
			int[] nums = queue.poll();
			if(nums[2]==1) {
				return count;
			}
			int x = nums[0];
			int y = nums[1];
			if(((x+1)<grid.length)&&!books[star][x+1][y]) {
				int[] temp = {x+1,y,grid[x+1][y]};
				queue.offer(temp);
				books[star][x+1][y] = true;
			}
			if(((y+1)<grid.length)&&!books[star][x][y+1]) {
				int[] temp = {x,y+1,grid[x][y+1]};
				queue.offer(temp);
				books[star][x][y+1] = true;
			}
			if(((nums[0]-1)>=0)&&!books[star][nums[0]-1][nums[1]]) {
				int[] temp = {x-1,y,grid[x-1][y]};
				queue.offer(temp);
				books[star][x-1][y] = true;
			}
			if(((nums[1]-1)>=0)&&!books[star][nums[0]][nums[1]-1]) {
				int[] temp = {x,y-1,grid[x][y-1]};
				queue.offer(temp);
				books[star][x][y-1] = true;
			}
		}
		return check(queue, books, grid, count+1, star);
	}
}

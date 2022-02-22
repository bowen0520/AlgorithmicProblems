package leetcode.test0651to0700;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode688 {
    public double knightProbability(int n, int k, int row, int column) {
        double step = 0.125d;

        Queue<int[]> que = new LinkedList<int[]>();
        que.offer(new int[] {row, column});
        double an = 1.0d;
        
        int[][] dir = new int[][] {{1,2},{2, 1},{2, -1},{1, -2},{-1, -2},{-2, -1},{-2, 1},{-1, 2}};
        
        for(int i = 0; i < k; i++) {
        	int size = que.size();
        	for(int s = 0; s < size; s++) {
	        	int[] node = que.poll();
	        	for(int j = 0; j < 8; j++) {
	        		int x = node[0] + dir[j][0];
	        		int y = node[1] + dir[j][1];
	        		
	        		if(x < 0 || x >= n || y < 0 || y >= n) {
	        			an = an - step;
	        		}else {
						que.offer(new int[] {x, y});
					}
	        	}
        	}
        	step = step*step;
        }
        return an;
    }
}

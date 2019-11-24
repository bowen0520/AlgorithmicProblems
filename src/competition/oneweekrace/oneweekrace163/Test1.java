package competition.oneweekrace.oneweekrace163;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
        int row = grid.length;
        if(row==0) {
        	return lists;
        }
        int column = grid[0].length;
        int len = row*column;
        
        k = k%(len);
        
        int start = len - k;
        
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i = start;i<len;i++) {
        	int x = i/column;
        	int y = i%column;
        	list.add(grid[x][y]);
        	if(list.size()==column) {
        		lists.add(list);
        		list = new ArrayList<Integer>();
        	}
        }
        for(int j = 0;j<start;j++) {
        	int x = j/column;
        	int y = j%column;
        	list.add(grid[x][y]);
        	if(list.size()==column) {
        		lists.add(list);
        		list = new ArrayList<Integer>();
        	}
        }
        return lists;
    }
}

package competition.oneweekrace.oneweekrace164;

public class Test2 {
    public int countServers(int[][] grid) {
        
        boolean[][] books = new boolean[grid.length][grid[0].length];
        
        int sum = 0;
        for(int i = 0;i<grid.length;i++) {
        	for(int j = 0;j<grid[0].length;j++) {
        		if(grid[i][j] == 1&&!books[i][j]) {
        			sum = count(grid,books,sum,i,j);
        		}
        	}
        }
        return sum;
    }
    
    public int count(int[][] grid,boolean[][] books,int sum,int x,int y) {
    	boolean flag = false;
    	
    	for(int i = 0;i<grid.length;i++) {
    		if(i != x&&grid[i][y] == 1) {
    			if(!books[i][y]) {
    				sum++;
    				books[i][y] = true;
    			}
    			flag = true;
    		}
    	}
    	
    	for(int j = 0;j<grid[0].length;j++) {
    		if(j != y&&grid[x][j] == 1) {
    			if(!books[x][j]) {
    				sum++;
    				books[x][j] = true;
    			}
    			flag = true;
    		}
    	}
    	
    	if(flag) {
    		sum++;
    		books[x][y] = true;
    	}
    	
    	return sum;
    	
    }
}

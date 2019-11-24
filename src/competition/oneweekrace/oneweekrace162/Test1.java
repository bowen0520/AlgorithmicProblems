package competition.oneweekrace.oneweekrace162;

public class Test1 {
	public int oddCells(int n, int m, int[][] indices) {
		int[][] map = new int[n][m];
        for(int i=0;i<indices.length;i++) {
        	int x = indices[i][0];
        	int y = indices[i][1];
        	for(int j = 0;j<m;j++) {
        		map[x][j]++;
        	}
        	for(int s = 0;s<n;s++) {
        		map[s][y]++;
        	}
        }
        
        int count = 0;
        boolean[][] book = new boolean[n][m];
        for(int i=0;i<indices.length;i++) {
        	int x = indices[i][0];
        	int y = indices[i][1];
        	for(int j = 0;j<m;j++) {
        		if(map[x][j]%2==1&&!book[x][j]) {
        			count++;
        			book[x][j]=true;
        		}
        	}
        	for(int s = 0;s<n;s++) {
        		if(map[s][y]%2==1&&!book[s][y]){
        			count++;
        			book[s][y]=true;
        		}
        	}
        	
        }
        
        return count;
    }
}

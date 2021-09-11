package leetcode.test0501to0550;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode547 {
    public int findCircleNum(int[][] isConnected) {
    	int num = 0;
    	boolean[] book = new boolean[isConnected.length];
    	
    	for(int i = 0; i < isConnected.length; i++) {
    		if(book[i]) {
    			continue;
    		}
    		book[i] = true;
    		Queue<Integer> queue = new LinkedList<Integer>();
    		
    		for(int j = i + 1; j < isConnected[i].length; j++) {
    			if(isConnected[i][j] == 1 && !book[j]) {
    				book[j] = true;
    				queue.offer(j);
    			}
    		}
    		
    		while(!queue.isEmpty()) {
    			int in = queue.poll();
    			for(int jn = 0;jn < isConnected[in].length;jn++) {
    				if(isConnected[in][jn] == 1 && !book[jn]) {
        				book[jn] = true;
        				queue.offer(jn);
        			}
    			}
    		}
    		num++;
    	}
    	return num;
    }
    
    
    public int findCircleNum2(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, provinces, i);
                circles++;
            }
        }
        return circles;
    }

    public void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }
}

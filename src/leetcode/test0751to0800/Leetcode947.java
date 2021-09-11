package leetcode.test0751to0800;

import java.util.HashSet;
import java.util.Set;

public class Leetcode947 {
    public int removeStones(int[][] stones) {
        int[] book = new int[stones.length];
        int color = 1;
        
        for(int i = 0; i < stones.length ;i++) {
        	int colorbook = 0;
        	for(int j = 0; j< i;j++) {
        		if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
        			if(colorbook == 0) {
        				book[i] = book[j];
        				colorbook = book[j];
        			}
        			if(colorbook != 0 && colorbook != book[j]) {
        				putColor(book, book[j], colorbook);
        			}
        		}
        	}
        	if(colorbook == 0) {
        		book[i] = color;
        		color ++;
        	}
        }
        
        Set<Integer> colors = new HashSet<Integer>();
        
        for(int c : book) {
        	colors.add(c);
        }
        
        return stones.length - colors.size();
    }
    
    public void putColor(int[] book, int oldColor, int color) {
		for(int i = 0; i < book.length; i++) {
			if(book[i] == oldColor) {
				book[i] = color;
			}
		}
	}
    
    public int[] findRedundantConnection(int[][] edges) {
        int color = 1;
        int[] book = new int[edges.length + 1];
        
        for(int[] edge:edges) {
            if(book[edge[0]] != 0 && book[edge[1]] != 0) {
            	if(book[edge[0]] == book[edge[1]]) {
            		return edge;
            	}else {
            		putColor(book, book[edge[1]], book[edge[0]]);
            	}
            }else if(book[edge[0]] != 0) {
        		book[edge[1]] = book[edge[0]];
        	}else if(book[edge[1]] != 0) {
        		book[edge[0]] = book[edge[1]];
        	}else {
        		book[edge[0]] = color;
        		book[edge[1]] = color;
        		color++;
        	}
        }
        return new int[2];
    }
}

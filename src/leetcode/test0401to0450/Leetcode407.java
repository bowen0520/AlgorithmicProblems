package leetcode.test0401to0450;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode407 {
	int[][] dir = new int[][] {{-1, 0},{1, 0},{0, -1},{0, 1}};
	
	public int trapRainWater(int[][] heightMap) {
		
		int length = heightMap.length;
		int wigth = heightMap[0].length;
		boolean[][] book = new boolean[length][wigth];
        for(int i = 0; i < length; i++) {
        	for(int j = 0; j < wigth; j++) {
        		boolean flag = true;
                if(i == 0 || i == length - 1 || j == 0 || j == wigth - 1) {
        			book[i][j] = flag;
                    continue;
        		}

        		for(int k = 0; k < dir.length; k++) {
        			int x = i + dir[k][0];
        			int y = j + dir[k][1];
        			if(x < 0 || x >= length || y < 0 || y >= wigth || heightMap[i][j] >= heightMap[x][y]) {
        				
        			}else {
						flag = false;
						break;
					}
        		}
        		book[i][j] = flag;
        	}
        }
        for(int i = 0; i < length ; i++) {
        	System.out.println(Arrays.toString(book[i]));
        }
        int an = 0;
        for(int i = 1; i < length - 1; i++) {
        	for(int j = 1; j < wigth - 1; j++) {
        		if(!book[i][j]) {
        			an = help(heightMap, book, an, i, j);
        		}
        	}
        }
        return an;
    }
	
	public int help(int[][] heightMap, boolean[][] book, int an, int x, int y) {
		int length = heightMap.length;
		int wigth = heightMap[0].length;
		int[][] dir = new int[][] {{-1, 0},{1, 0},{0, -1},{0, 1}};
		boolean[][] note = new boolean[length][wigth];
		int min = Integer.MAX_VALUE;
		List<int[]> list = new ArrayList<int[]>();
		list.add(new int[] {x, y});
		int index = 0;
		note[x][y] = true;
		boolean flag = true;
        while(index < list.size()) {
        	int[] node = list.get(index);
        	for(int k = 0; k < dir.length; k++) {
    			int i = node[0] + dir[k][0];
    			int j = node[1] + dir[k][1];
    			if(i >= 0 && i < length && j >= 0 && j < wigth) {
    				if(!note[i][j]) {
	    				if(book[i][j]) {
	    					min = Math.min(min, heightMap[i][j]);
	    					if(heightMap[i][j] < heightMap[node[0]][node[1]]) {
	    						flag = false;
	    					}
	    				}else {
							list.add(new int[] {i,j});
							note[i][j] = true;
						}
    				}
    			}else {
					flag = false;
				}
    		}
        	index++;
        }
        for(int i = 0; i < length ; i++) {
        	System.out.println(Arrays.toString(note[i]));
        }
        System.out.println(min);
        for(int i = 0; i < list.size(); i++) {
        	int[] node = list.get(i);
        	book[node[0]][node[1]] = true;
        	if(flag) {
        		an = an + min - heightMap[node[0]][node[1]];
        	}
        }
        
        return an;
    }
}

package leetcode.test1001to1050;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Leetcode1034 {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int baseColor = grid[row][col];
        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        boolean[][] pathFlag = new boolean[grid.length][grid[0].length];
        boolean[][] colorFlag = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<int[]>();
        Set<String> book = new HashSet<String>();
        
        pathFlag[row][col] = true;
        queue.offer(new int[] {row, col});
        book.add(row + " " + col);
        
        
        while(!queue.isEmpty()) {
        	int[] idx = queue.poll();
        	boolean cf = false;
        	for(int i = 0; i < dir.length; i++) {
        		int x = idx[0] + dir[i][0];
        		int y = idx[1] + dir[i][1];
        		String flag = x + " " + y;
        		if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
        			
        			if(grid[x][y] == baseColor) {
        				if(!book.contains(flag)) {
	        				pathFlag[x][y] = true;
	        		        queue.offer(new int[] {x, y});
        				}else {
        					book.add(flag);
						}
        			}else {
						cf = true;
					}
        		}else {
					cf = true;
				}
        	}
        	if(cf) {
        		colorFlag[idx[0]][idx[1]] = true;
        	}
        }
        
        for(int i = 0; i < grid.length; i++) {
        	for(int j = 0; j < grid[0].length; j++) {
        		if(colorFlag[i][j]) {
        			grid[i][j] = color;
        		}
        	}
        }
        return grid;
    }
	
	/*
	 * 给你一个大小为 m x n 的整数矩阵 grid ，表示一个网格。另给你三个整数 row、col 和 color 。网格中的每个值表示该位置处的网格块的颜色。

两个网格块属于同一 连通分量 需满足下述全部条件：

两个网格块颜色相同
在上、下、左、右任意一个方向上相邻
连通分量的边界 是指连通分量中满足下述条件之一的所有网格块：

在上、下、左、右四个方向上与不属于同一连通分量的网格块相邻
在网格的边界上（第一行/列或最后一行/列）
请你使用指定颜色 color 为所有包含网格块 grid[row][col] 的 连通分量的边界 进行着色，并返回最终的网格 grid 。

 

示例 1：

输入：grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
输出：[[3,3],[3,2]]
示例 2：

输入：grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
输出：[[1,3,3],[2,3,3]]
示例 3：

输入：grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
输出：[[2,2,2],[2,1,2],[2,2,2]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/coloring-a-border
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
}

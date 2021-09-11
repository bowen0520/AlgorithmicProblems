package leetcode.test0801to0850;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode802 {
	
	public static void main(String[] args) {
		
	}

	
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        boolean[][] map = new boolean[graph.length][graph.length];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < i; j++){
                if(map[j][i]){
                    for(int k = 0; k < graph[i].length; k++){
                        map[j][graph[i][k]] = true;
                    }
                }
            }

            for(int k = 0; k < graph[i].length; k++){
                map[i][graph[i][k]] = true;
            }
        }
        
        for(int i = 0; i <  graph.length; i++) {
        	System.out.println(Arrays.toString(map[i]));
        }


        for(int i = 0; i< graph.length;i++){
            boolean flag = true;
            for(int j = i;j < graph.length;j++){
                if(map[i][j] && map[j][i]){
                    flag = false;
                    break;
                }
            }

            if(flag){
                list.add(i);
            }
        }

        return list;
    }
}

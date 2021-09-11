package leetcode.test1201to1250;

import java.util.HashSet;
import java.util.Set;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.IconifyAction;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Leetcode1584 {
	 public int minCostConnectPoints(int[][] points) {
	    	int pn = points.length;
	    	if(pn <= 1) {
	    		return 0;
	    	}
	    	
	    	int[][] lenMap = buildMap(points);
	    	
	    	int an = 0;
	    	
	    	Set<Integer> bookSet = new HashSet<Integer>();
	    	bookSet.add(0);
	    	
	    	
	    	while(bookSet.size() != pn) {
	    		int min = Integer.MAX_VALUE;
	    		int index = 0;
	    		for(int p:bookSet) {
	    			for(int j = 0; j< pn; j++) {
		    			if(j != p && !bookSet.contains(j)) {
		    				if(lenMap[p][j] < min) {
		    					min = lenMap[p][j];
		    					index = j;
		    				}
		    			}
		    		}
	    		}
	    		
	    		bookSet.add(index);
    			an += min;
	    	}
	    
	    	
	    	return an;
	    }
	    
	    public int[][] buildMap(int[][] points){
	    	int pn = points.length;
	    	int[][] an = new int[pn][pn];
	    	
	    	for(int i = 0; i < pn;i ++) {
	    		for(int j = 0; j< pn; j++) {
	    			an[i][j] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
	    		}
	    	}
	    	
	    	return an;
	    }
}

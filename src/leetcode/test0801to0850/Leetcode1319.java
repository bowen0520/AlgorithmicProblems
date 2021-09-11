package leetcode.test0801to0850;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/*
 * 用以太网线缆将 n 台计算机连接成一个网络，计算机的编号从 0 到 n-1。线缆用 connections 表示，其中 connections[i] = [a, b] 连接了计算机 a 和 b。

网络中的任何一台计算机都可以通过网络直接或者间接访问同一个网络中其他任意一台计算机。

给你这个计算机网络的初始布线 connections，你可以拔开任意两台直连计算机之间的线缆，并用它连接一对未直连的计算机。请你计算并返回使所有计算机都连通所需的最少操作次数。如果不可能，则返回 -1 。 

 */
public class Leetcode1319 {
    public int makeConnected(int n, int[][] connections) {
    	if(connections.length < n-1) {
    		return -1;
    	}
    	
    	
    	int color = 1;
    	int[] bookcolor = new int[n];
    	for(int i = 0; i < connections.length; i++) {
    		if(bookcolor[connections[i][0]] != 0 && bookcolor[connections[i][1]] == 0) {
    			bookcolor[connections[i][1]] = bookcolor[connections[i][0]];
    		}else if(bookcolor[connections[i][0]] == 0 && bookcolor[connections[i][1]] != 0){
    			bookcolor[connections[i][0]] = bookcolor[connections[i][1]];
			}else if(bookcolor[connections[i][0]] == 0 && bookcolor[connections[i][1]] == 0){
				bookcolor[connections[i][1]] = color;
				bookcolor[connections[i][0]] = color;
				color ++;
			}else if(bookcolor[connections[i][0]] != bookcolor[connections[i][1]]) {
				putColor(bookcolor, bookcolor[connections[i][0]], bookcolor[connections[i][1]]);
			}
    	}
    	
    	return getPart(bookcolor) - 1;
    	
    }
    
    public void putColor(int[] bookcolor, int newColor, int oldColor) {
    	for(int i = 0; i < bookcolor.length; i++) {
    		if(oldColor == bookcolor[i]) {
    			bookcolor[i] = newColor;
    		}
    	}
    }
    
    public int getPart(int[] bookcolor) {
		int count = 0;
		Set<Integer> cIntegers = new HashSet<Integer>();
		for(int i:bookcolor) {
			if(i==0) {
				count++;
			}else {
				cIntegers.add(i);
			}
		}
		return count + cIntegers.size();
	}
}

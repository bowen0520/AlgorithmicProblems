package leetcode.test801to850;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class Leetcode841 {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] books = new boolean[rooms.size()];
        Queue<Integer> que = new ArrayDeque<>();
        que.offer(0);
        books[0]=true;
        while(!que.isEmpty()) {
        	int i = que.poll();
        	List<Integer> list = rooms.get(i);
        	for(int in:list) {
        		if(!books[in]) {
        			que.offer(in);
        	        books[in]=true;
        		}
        	}
        }
        for(boolean f:books) {
        	if(!f) {
        		return false;
        	}
        }
        return true;
    }
}

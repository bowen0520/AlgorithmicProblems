package competition.biweeklytournament.biweeklytournament14;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Test1 {
	/*public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
		int len = intervals.length;
	    List<List<Integer>> lists = new ArrayList<List<Integer>>();
	    if(toBeRemoved[0]>=intervals[len-1][1]) {
	    	return lists;
	    }
	    if(toBeRemoved[1]<=intervals[0][0]) {
	    	return lists;
	    }
		if(toBeRemoved[0]>intervals[0][0]&&toBeRemoved[1]>=intervals[len-1][1]) {
			for(int i = 0;i<intervals.length;i++) {
		    	List<Integer> list = new ArrayList<Integer>();
		    	if(intervals[i][1]<=toBeRemoved[0]) {
		    		list.add(intervals[i][0]);
		    		list.add(intervals[i][1]);
		    		lists.add(list);
		    	}else if(intervals[i][0]<toBeRemoved[0]){
		    		list.add(intervals[i][0]);
		    		list.add(toBeRemoved[0]);
		    		lists.add(list);
		    	}else {
		    		break;
		    	}
		    }
			return lists;
		}
		
		if(toBeRemoved[0]>intervals[0][0]&&toBeRemoved[1]<intervals[len-1][1]) {
			int i = 0;
			for(;i<intervals.length;i++) {
		    	List<Integer> list = new ArrayList<Integer>();
		    	if(intervals[i][1]<=toBeRemoved[0]) {
		    		list.add(intervals[i][0]);
		    		list.add(intervals[i][1]);
		    		lists.add(list);
		    	}else if(intervals[i][0]<toBeRemoved[0]){
		    		list.add(intervals[i][0]);
		    		list.add(toBeRemoved[0]);
		    		lists.add(list);
		    	}else {
		    		break;
		    	}
		    }
			for(;i<intervals.length;i++) {
				if(intervals[i][1]>toBeRemoved[1]) {
					List<Integer> list = new ArrayList<Integer>();
		    		list.add(toBeRemoved[1]);
		    		list.add(intervals[i][1]);
		    		lists.add(list);
		    		break;
		    	}else if(intervals[i][1]==toBeRemoved[1]) {
		    		break;
		    	}
			}
			for(;i<intervals.length;i++) {
				List<Integer> list = new ArrayList<Integer>();
		    	list.add(intervals[i][0]);
		    	list.add(intervals[i][1]);
		    	lists.add(list);
			}
			return lists;
		}
		if(toBeRemoved[0]<=intervals[0][0]&&toBeRemoved[1]<intervals[len-1][1]) {
			int i = 0;
			for(;i<intervals.length;i++) {
				if(intervals[i][1]>toBeRemoved[1]) {
					List<Integer> list = new ArrayList<Integer>();
		    		list.add(toBeRemoved[1]);
		    		list.add(intervals[i][1]);
		    		lists.add(list);
		    		break;
		    	}else if(intervals[i][1]==toBeRemoved[1]) {
		    		break;
		    	}
			}
			for(;i<intervals.length;i++) {
				List<Integer> list = new ArrayList<Integer>();
		    	list.add(intervals[i][0]);
		    	list.add(intervals[i][1]);
		    	lists.add(list);
			}
			return lists;
		}
		return lists;
	}*/
	
	public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
		int len = intervals.length;
	    List<List<Integer>> lists = new ArrayList<List<Integer>>();
	    
	    if(toBeRemoved[0]>=intervals[len-1][1]) {
	    	return lists;
	    }
	    if(toBeRemoved[1]<=intervals[0][0]) {
	    	return lists;
	    }
		if(toBeRemoved[0]<=intervals[0][0]&&toBeRemoved[1]>=intervals[len-1][1]) {
			return lists;
		}
	    
	    List<Integer> list = new ArrayList<Integer>();
	    list.add(toBeRemoved[0]);
	    list.add(toBeRemoved[1]);
	    for(int i = 0;i<len;i++) {
	    	list.add(intervals[i][0]);
	    	list.add(intervals[i][1]);
	    }
	    Collections.sort(list);
	    boolean flag = false;
	    for(int i = 0;i<list.size();i+=2) {
	    	if(!flag) {
	    		if(list.get(i)==toBeRemoved[0]) {
	    			flag = true;
	    		}else if(list.get(i+1)==toBeRemoved[0]){
	    			List<Integer> temp = new ArrayList<Integer>();
	    			temp.add(list.get(i));
	    			temp.add(list.get(i+1));
	    			lists.add(temp);
	    			flag = true;
	    		}else {
	    			List<Integer> temp = new ArrayList<Integer>();
	    			temp.add(list.get(i));
	    			temp.add(list.get(i+1));
	    			lists.add(temp);
	    		}
	    	}else {
	    		if(list.get(i+1)==toBeRemoved[1]) {
	    			flag = false;
	    		}else if(list.get(i)==toBeRemoved[1]){
	    			List<Integer> temp = new ArrayList<Integer>();
	    			temp.add(list.get(i));
	    			temp.add(list.get(i+1));
	    			lists.add(temp);
	    			flag = false;
	    		}
	    	}
	    }
	    return lists;
	}
}
/*
给你一个 有序的 不相交区间列表 intervals 和一个要删除的区间 toBeRemoved， intervals 中的每一个区间 intervals[i] = [a, b] 都表示满足 a <= x < b 的所有实数  x 的集合。

我们将 intervals 中任意区间与 toBeRemoved 有交集的部分都删除。

返回删除所有交集区间后， intervals 剩余部分的 有序 列表。

 

示例 1：

输入：intervals = [[0,2],[3,4],[5,7]], toBeRemoved = [1,6]
输出：[[0,1],[6,7]]
示例 2：

输入：intervals = [[0,5]], toBeRemoved = [2,3]
输出：[[0,2],[3,5]]
 

提示：

1 <= intervals.length <= 10^4
-10^9 <= intervals[i][0] < intervals[i][1] <= 10^9
*/
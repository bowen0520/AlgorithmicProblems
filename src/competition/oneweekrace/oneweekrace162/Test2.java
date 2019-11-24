package competition.oneweekrace.oneweekrace162;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
	public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		int len = colsum.length;
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		
		int count = 0;
		int sum = 0;
		for(int i = 0;i<len;i++) {
        	if(colsum[i]==2) {
        		count++;
        	}
        	sum += colsum[i];
        }
		
		if(sum!=(upper+lower)||count>upper||count>lower) {
			return lists;
		}
		
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		
        int head = upper-count;
        int tail = lower-count;
        for(int i = 0;i<len;i++) {
        	if(colsum[i]==1) {
        		if(head>0) {
        			list1.add(1);
        			list2.add(0);
        			head--;
        		}else if(tail>0){
        			list1.add(0);
        			list2.add(1);
        			tail--;
        		}else {
        			return lists;
        		}
        	}else if(colsum[i]==2) {
        		list1.add(1);
    			list2.add(1);
        	}else {
        		list1.add(0);
    			list2.add(0);
        	}
        }
        lists.add(list1);
        lists.add(list2);
        return lists;
    }
}

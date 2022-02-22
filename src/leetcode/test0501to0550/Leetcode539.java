package leetcode.test0501to0550;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class Leetcode539 {
    public int findMinDifference(List<String> timePoints) {
    	List<Integer> book = new ArrayList<Integer>();
    	for(String time: timePoints) {
    		int timeN = timeFormat(time);
    		book.add(timeN);
    		book.add(timeN + 1440);
    	}
    	
    	book.sort((a, b) -> {return a - b;});
    	
    	int min = 1440;
    	
    	for(int i = 1; i < book.size();i++) {
    		int cha = book.get(i) - book.get(i-1);
    		if(cha < min) {
    			min = cha;
    		}
    	}
    	
    	return min;
    	
    }
    
    public int timeFormat(String time) {
    	String[] times = time.split(":");
    	
    	int an = 60 * Integer.parseInt(times[0]) + Integer.parseInt(times[1]);
    	return an;
    }
}
/*
给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

 

示例 1：

输入：timePoints = ["23:59","00:00"]
输出：1
示例 2：

输入：timePoints = ["00:00","23:59","00:00"]
输出：0
 

提示：

2 <= timePoints.length <= 2 * 104
timePoints[i] 格式为 "HH:MM"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/minimum-time-difference
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
**/
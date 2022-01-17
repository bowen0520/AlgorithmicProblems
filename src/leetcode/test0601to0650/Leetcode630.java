package leetcode.test0601to0650;

import java.awt.font.TextMeasurer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode630 {
	
    public int scheduleCourse1(int[][] courses) {
    	Map<String, Integer> book = new HashMap<String, Integer>();
    	
    	Arrays.sort(courses, (a, b) ->{ return a[1] - b[1];});
    	for(int[] a: courses) {
        	System.out.println(Arrays.toString(a));
    	}
    	return scheduleCourse1(courses, 0, 0, 0, book);
    }
    
    public int scheduleCourse1(int[][] courses, int index, int timesum, int an, Map<String, Integer> book) {
    	if(index >= courses.length) {
    		return an;
    	}
    	String key = timesum + " " + index;
    	if(book.containsKey(key)) {
    		book.get(key);
    	}
    	int ans = scheduleCourse1(courses, index + 1, timesum, an, book);
    	if(courses[index][0] + timesum <= courses[index][1]) {
    		int temp = scheduleCourse1(courses, index + 1, courses[index][0] + timesum, an + 1, book);
    		if(temp > ans) {
    			ans = temp;
    		}
    	}
    	book.put(key, ans);
    	return ans;
    }
 
    //当队列中的总时长超过目前所要的时长，就把时长最长的课弹出
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);

        PriorityQueue<Integer> q = new PriorityQueue<Integer>((a, b) -> b - a);
        // 优先队列中所有课程的总时间
        int total = 0;

        for (int[] course : courses) {
            int ti = course[0], di = course[1];
            if (total + ti <= di) {
                total += ti;
                q.offer(ti);
            } else if (!q.isEmpty() && q.peek() > ti) {
                total -= q.poll() - ti;
                q.offer(ti);
            }
        }

        return q.size();
    }
    
}

/*
这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。

你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。

返回你最多可以修读的课程数目。

 

示例 1：

输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
输出：3
解释：
这里一共有 4 门课程，但是你最多可以修 3 门：
首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。
示例 2：

输入：courses = [[1,2]]
输出：1
示例 3：

输入：courses = [[3,2],[4,3]]
输出：0
 

提示:

1 <= courses.length <= 104
1 <= durationi, lastDayi <= 104

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/course-schedule-iii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
package leetcode.test0351to0400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode352 {
	class SummaryRanges {

	    private int[] father = new int[10001];

	    public SummaryRanges() {
	        // 元素值的范围为 0~10000，所以，初始化为-1
	        Arrays.fill(father, -1);
	    }
	    
	    public void addNum(int val) {
	        if (father[val] == -1) {
	            father[val] = val;
	            // 先合并右边，再合并左边
	            if(val + 1 < father.length && father[val + 1] != -1) {
	            	father[val] = father[val + 1];
	            }
	            int an = val-1;
	            while(an >= 0 && father[an] != -1) {
	            	father[an] = father[an + 1];
	            	an--;
	            }
	        }
	    }
	    
	    public int[][] getIntervals() {
	        List<int[]> list = new ArrayList<>();

	        for (int i = 0; i < 10001;) {
	            if (father[i] != -1) {
	                int start = i;
	                // 快速找到右边界
	                int end = father[i];
	                list.add(new int[] {start, end});
	                i = end + 1;
	            } else {
	                i++;
	            }
	        }

	        return list.toArray(new int[list.size()][2]);
	    }
	}
}
/*
 *  给你一个由非负整数 a1, a2, ..., an 组成的数据流输入，请你将到目前为止看到的数字总结为不相交的区间列表。

实现 SummaryRanges 类：

SummaryRanges() 使用一个空数据流初始化对象。
void addNum(int val) 向数据流中加入整数 val 。
int[][] getIntervals() 以不相交区间 [starti, endi] 的列表形式返回对数据流中整数的总结。
 

示例：

输入：
["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
[[], [1], [], [3], [], [7], [], [2], [], [6], []]
输出：
[null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

解释：
SummaryRanges summaryRanges = new SummaryRanges();
summaryRanges.addNum(1);      // arr = [1]
summaryRanges.getIntervals(); // 返回 [[1, 1]]
summaryRanges.addNum(3);      // arr = [1, 3]
summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3]]
summaryRanges.addNum(7);      // arr = [1, 3, 7]
summaryRanges.getIntervals(); // 返回 [[1, 1], [3, 3], [7, 7]]
summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
summaryRanges.getIntervals(); // 返回 [[1, 3], [7, 7]]
summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
summaryRanges.getIntervals(); // 返回 [[1, 3], [6, 7]]
 

提示：

0 <= val <= 104
最多调用 addNum 和 getIntervals 方法 3 * 104 次

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
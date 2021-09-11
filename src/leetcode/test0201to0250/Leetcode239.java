package leetcode.test0201to0250;

import java.util.Deque;
import java.util.LinkedList;

/*
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。

返回滑动窗口中的最大值。

 

示例 1：

输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
输出：[3,3,5,5,6,7]
解释：
滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
示例 2：

输入：nums = [1], k = 1
输出：[1]
示例 3：

输入：nums = [1,-1], k = 1
输出：[1,-1]
示例 4：

输入：nums = [9,11], k = 2
输出：[11]
示例 5：

输入：nums = [4,-2], k = 2
输出：[4]
 

提示：

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length

 */
public class Leetcode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
    	if(k == 1) {
    		return nums;
    	}
    	int[] ans = new int[nums.length - k + 1];
    	for(int i = 0; i < nums.length - k + 1; i++) {
    		ans[i] = getMax(nums, i, i + k - 1);
    	}
    	return ans;
    }
    
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < k; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; ++i) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            ans[i - k + 1] = nums[deque.peekFirst()];
        }
        return ans;
    }
    
    public int getMax(int[] nums, int start, int end) {
    	int max = nums[start];
    	for(int i = start + 1; i <= end; i++) {
    		if(nums[i] > max) {
    			max = nums[i];
    		}
    	}
    	return max;
    }
    
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        int[] que = new int[nums.length];
        int start = 0;
        int end = 0;
        for (int i = 0; i < k; ++i) {
            while (start < end && nums[i] >= nums[que[end-1]]) {
                end--;
            }
            que[end++] = i;
        }

        int[] ans = new int[n - k + 1];
        ans[0] = nums[que[start]];
        for (int i = k; i < n; ++i) {
            while (start < end && nums[i] >= nums[que[end-1]]) {
            	end--;
            }
            que[end++] = i;
            while (que[start] <= i - k) {
                start++;
            }
            ans[i - k + 1] = nums[que[start]];
        }
        return ans;
    }
}

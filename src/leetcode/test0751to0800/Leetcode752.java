package leetcode.test0751to0800;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Leetcode752 {
	static public void main(String[] args) {
	}
	public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<String>();
        for(String s:deadends) {
        	set.add(s);
        }
        Queue<String> que = new ArrayDeque<String>();
        if(set.contains("0000")) {
        	return -1;
        }
        que.add("0000");
        set.add("0000");
        int count = 0;
        while(!que.isEmpty()) {
        	int size = que.size();
        	for(int i = 0;i<size;i++) {
        		String str = que.poll();
        		if(str.equals(target)) {
        			return count;
        		}
        		
        		handle(que, set, getNewStr(str.toCharArray(), 0, 1));
        		
        		handle(que,set,getNewStr(str.toCharArray(), 1, 1));
        		
        		handle(que,set,getNewStr(str.toCharArray(), 2, 1));
        		
        		handle(que,set,getNewStr(str.toCharArray(), 3, 1));
        		
        		handle(que, set, getNewStr(str.toCharArray(), 0, -1));
        		
        		handle(que, set, getNewStr(str.toCharArray(), 1, -1));
        		
        		handle(que, set, getNewStr(str.toCharArray(), 2, -1));
        		
        		handle(que, set, getNewStr(str.toCharArray(), 3, -1));
        		
        	}
        	count++;
        }
        return -1;
        
    }
	
	public void handle(Queue<String> que,Set<String> set,String s) {
		if(!set.contains(s)) {
			que.add(s);
			set.add(s);
		}
	}
	
	public String getNewStr(char[] c,int index,int handle) {
		char getNew = (char) (c[index]+handle);
		c[index] = getNew>'9'?'0':(getNew<'0'?'9':getNew);
		return new String(c);
	}
}
/*
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

 

示例 1:

输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
输出：6
解释：
可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
因为当拨动到 "0102" 时这个锁就会被锁定。
示例 2:

输入: deadends = ["8888"], target = "0009"
输出：1
解释：
把最后一位反向旋转一次即可 "0000" -> "0009"。
示例 3:

输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
输出：-1
解释：
无法旋转到目标数字且不被锁定。
示例 4:

输入: deadends = ["0000"], target = "8888"
输出：-1
 

提示：

死亡列表 deadends 的长度范围为 [1, 500]。
目标数字 target 不会在 deadends 之中。
每个 deadends 和 target 中的字符串的数字会在 10,000 个可能的情况 '0000' 到 '9999' 中产生。
*/
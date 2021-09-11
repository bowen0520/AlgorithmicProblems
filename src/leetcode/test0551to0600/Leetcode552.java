package leetcode.test0551to0600;

import java.util.HashMap;
import java.util.Map;

public class Leetcode552 {
	
    int a = 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 * 10 + 7;

    public int checkRecord(int n) {
		int[][][] map = new int[n][2][3];
    	return checkRecord(1, 0, 0, n, map) ;
    }
    
    public int checkRecord(int idx, int numA, int numL, int n, int[][][] map) {
    	if(idx > n) {
    		return 1;
    	}
    	if(map[idx-1][numA][numL] != 0) {
    		return map[idx-1][numA][numL];
    	}
    	long an = 0;
    	if(numA < 1) {
    		an = an + checkRecord(idx + 1, numA + 1, 0, n, map);
    	}
    	
    	if(numL < 2) {
    		an = an + checkRecord(idx + 1, numA, numL + 1, n, map);
    	}
    	
    	an = an + checkRecord(idx + 1, numA, 0, n, map);
    	map[idx-1][numA][numL] = (int)(an%a);
    	return (int)(an%a);
    }
    
    public static void main(String[] args) {
		System.out.println(checkRecord(55555));
	}
    
    /*
     * 可以用字符串表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符：
'A'：Absent，缺勤
'L'：Late，迟到
'P'：Present，到场
如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励：

按 总出勤 计，学生缺勤（'A'）严格 少于两天。
学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。
给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量 。答案可能很大，所以返回对 109 + 7 取余 的结果。

 

示例 1：

输入：n = 2
输出：8
解释：
有 8 种长度为 2 的记录将被视为可奖励：
"PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL" 
只有"AA"不会被视为可奖励，因为缺勤次数为 2 次（需要少于 2 次）。
示例 2：

输入：n = 1
输出：3
示例 3：

输入：n = 10101
输出：183236316

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/student-attendance-record-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
}

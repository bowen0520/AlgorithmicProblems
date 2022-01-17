package leetcode.test0801to0850;

import java.util.Arrays;

public class Leetcode846 {
    public boolean isNStraightHand2(int[] hand, int groupSize) {
    	if(hand.length%groupSize != 0) {
    		return false;
    	}
    	Arrays.sort(hand);
    	int len = hand.length/groupSize;
    	
    	int[] an = new int[len];
    	int[] anLen = new int[len];
    	Arrays.fill(an, -1);
    	for(int i = 0; i < hand.length; i++) {
    		boolean flag = false;
    		for(int j = 0; j < an.length; j++) {
    			if(anLen[j] >= groupSize){
                    continue;
                }
    			if(an[j] == -1 || an[j] - hand[i] == 1) {
    				an[j] = hand[i];
    				anLen[j]++;
    				flag = true;
    				break;
    			}
    		}
    		if(!flag) {
    			return false;
    		}
    	}
    	return true;
    }
    
    public boolean isNStraightHand(int[] hand, int groupSize) {
    	if(hand.length%groupSize != 0) {
    		return false;
    	}
    	//Arrays.sort(hand);
    	int len = hand.length/groupSize;
    	
    	int[][] an = new int[len][2];
    	int[] anLen = new int[len];
    	Arrays.fill(an, -1);
    	for(int i = 0; i < hand.length; i++) {
    		boolean flag = false;
    		for(int j = 0; j < an.length; j++) {
    			if(anLen[j] >= groupSize){
                    continue;
                }
    			if(an[j][0] == -1) {
    				an[j][0] = hand[i];
    				anLen[j]++;
    				flag = true;
    				break;
    			}else if(hand[i] - an[j][0] == 1){
					
				}
    		}
    		if(!flag) {
    			return false;
    		}
    	}
    	return true;
    }
}
/*
Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。

给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。

 

示例 1：

输入：hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
输出：true
解释：Alice 手中的牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
示例 2：

输入：hand = [1,2,3,4,5], groupSize = 4
输出：false
解释：Alice 手中的牌无法被重新排列成几个大小为 4 的组。
 

提示：

1 <= hand.length <= 104
0 <= hand[i] <= 109
1 <= groupSize <= hand.length

 */
package leetcode.test1201to1250;

import java.util.Arrays;
import java.util.Collections;

public class Leetcode1996 {
/*
 * 你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。

如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。

返回 弱角色 的数量。

 

示例 1：

输入：properties = [[5,5],[6,3],[3,6]]
输出：0
解释：不存在攻击和防御都严格高于其他角色的角色。
示例 2：

输入：properties = [[2,2],[3,3]]
输出：1
解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
示例 3：

输入：properties = [[1,5],[10,4],[4,3]]
输出：1
解释：第三个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
 

提示：

2 <= properties.length <= 105
properties[i].length == 2
1 <= attacki, defensei <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/the-number-of-weak-characters-in-the-game
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
	
	
    public int numberOfWeakCharacters(int[][] properties) {
    	int an = 0;
    	Arrays.sort(properties, (int[] a, int[] b) -> {
    		if(a[0] == b[0]) {
    			return b[1] - a[1];
    		}else {
    			return b[0] - a[0];
    		}
    	});
    	
    	for(int j = 0; j < properties.length; j++) {
    		System.out.println(properties[j][0] + " " + properties[j][1]);
    	}
    	
    	int maxDef = 0;
    	for(int i = 0; i < properties.length;) {
    		int temp = i;
    		int maxDefTemp = maxDef;
    		while(i < properties.length &&  properties[i][0] == properties[temp][0]) {
    			if(properties[i][1] < maxDef) {
    				an++;
    			}
    			if(properties[i][1] > maxDefTemp) {
    				maxDefTemp = properties[i][1];
    			}
    			i++;
    		}
    		maxDef = maxDefTemp;
    	}
    	
    	return an;
    }
}

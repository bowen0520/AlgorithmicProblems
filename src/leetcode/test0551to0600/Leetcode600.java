package leetcode.test0551to0600;

import java.util.HashSet;
import java.util.Set;

public class Leetcode600 {
	public int findIntegers(int n) {
    	Set<Integer> set = new HashSet<Integer>();
    	int an = n + 1;
    	for(int i = 0; i <= n; i++) {
    		int num = i;
    		boolean flag = false;
    		while(num > 0) {
    			if(set.contains(num/2)) {
    				an--;
					set.add(i);
					break;
    			}
    			if(num%2 == 1) {
    				if(flag) {
    					an--;
    					set.add(i);
    					break;
    				} else {
						flag = true;
					}
    			}else {
					flag = false;
				}
                num = num/2;
    		}
    	}
    	
    	return an;
    }
	
	
    public int findIntegers1(int n) {
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int pre = 0, res = 0;
        for (int i = 29; i >= 0; --i) {
            int val = 1 << i;
            if ((n & val) != 0) {
                res += dp[i + 1];
                if (pre == 1) {
                    break;
                }
                pre = 1;
            } else {
                pre = 0;
            }

            if (i == 0) {
                ++res;
            }
        }

        return res;
    }
}

class Solution {
    public int findIntegers(int n) {
        // 预处理第 i 层满二叉树的路径数量
        int[] dp = new int[31];
        dp[0] = dp[1] = 1;
        for (int i = 2; i < 31; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // pre 记录上一层的根节点值，res 记录最终路径数
        int pre = 0, res = 0;
        for (int i = 29; i >= 0; --i) {
            int val = 1 << i;
            // if 语句判断 当前子树是否有右子树
            if ((n & val) != 0) {
                // 有右子树
                n -= val;
                res += dp[i + 1]; // 先将左子树（满二叉树）的路径加到结果中

                // 处理右子树
                if (pre == 1) {
                    // 上一层为 1，之后要处理的右子树根节点肯定也为 1
                    // 此时连续两个 1，不满足题意，直接退出
                    break;
                }
                // 标记当前根节点为 1
                pre = 1;
            } else {
                // 无右子树，此时不能保证左子树是否为满二叉树，所以要在下一层再继续判断
                pre = 0;
            }

            if (i == 0) {
                ++res;
            }
        }

        return res;
    }
}
/*
 * 给定一个正整数 n，找出小于或等于 n 的非负整数中，其二进制表示不包含 连续的1 的个数。

示例 1:

输入: 5
输出: 5
解释: 
下面是带有相应二进制表示的非负整数<= 5：
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
其中，只有整数3违反规则（有两个连续的1），其他5个满足规则。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/non-negative-integers-without-consecutive-ones
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

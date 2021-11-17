package leetcode.test0501to0550;

import java.util.Arrays;

public class Leetcode517 {
    public int findMinMoves2(int[] machines) {
    	int len = machines.length;
    	int[] sum = new int[len];
    	sum[0] = machines[0];
    	for(int i = 1; i < len; i++) {
    		sum[i] = sum[i-1] + machines[i];
    	}
    	int an = 0;
    	if(sum[len - 1] % len != 0) {
    		return -1;
    	}else {
			int num = sum[len - 1] / len;
			
			boolean flag = true;
			while(flag) {
				flag = false;
				
				for(int i = 0; i < len; i++) {
					if(i == 0 && sum[i] > num) {
						sum[i]--;
						machines[i]--;
						machines[i + 1]++;
						flag = true;
					}else if(i == len-1 && machines[i] > num) {
						sum[i - 1]++;
						machines[i]--;
						machines[i - 1]++;
						flag = true;
					}else if(machines[i] != 0){
						if(i * num > sum[i] - machines[i]) {
							sum[i - 1]++;
							machines[i]--;
							machines[i - 1]++;
							flag = true;
						}else if((len - i - 1) * num > sum[len - 1] - sum[i]){
							sum[i]--;
							machines[i]--;
							machines[i + 1]++;
							flag = true;
						}
					}
				}
				if(flag) {
					an++;
				}
			}
			return an;
		}
    }
    
    public int findMinMoves(int[] machines) {
    	int len = machines.length;
    	int[] sum = new int[len];
    	sum[0] = machines[0];
    	for(int i = 1; i < len; i++) {
    		sum[i] = sum[i-1] + machines[i];
    	}
    	if(sum[len - 1] % len != 0) {
    		return -1;
    	}else {
			int num = sum[len - 1] / len;
			int an = 0;
			boolean flag = true;
			boolean[] book = new boolean[len];
			while(flag) {
				flag = false;
				
				for(int i = 0; i < len; i++) {
					if(machines[i] != 0 && !book[i]) {
						if(i * num > sum[i] - machines[i]) {
							sum[i - 1]++;
							machines[i]--;
							machines[i - 1]++;
							flag = true;
						}else if((len - i - 1) * num > sum[len - 1] - sum[i]){
							sum[i]--;
							machines[i]--;
							machines[i + 1]++;
							flag = true;
						}else {
							book[i] = true;
						}
					}
				}
				if(flag) {
					an++;
				}
			}
			return an;
		}
    }
    
    
    public int findMinMoves3(int[] machines) {
        int tot = Arrays.stream(machines).sum();
        int n = machines.length;
        if (tot % n != 0) {
            return -1;
        }
        int avg = tot / n;
        int ans = 0, sum = 0;
        for (int num : machines) {
            num -= avg;
            sum += num;
            ans = Math.max(ans, Math.max(Math.abs(sum), num));
        }
        return ans;
    }

}
/*
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。

在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。

给定一个整数数组 machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。如果不能使每台洗衣机中衣物的数量相等，则返回 -1 。

 

示例 1：

输入：machines = [1,0,5]
输出：3
解释：
第一步:    1     0 <-- 5    =>    1     1     4
第二步:    1 <-- 1 <-- 4    =>    2     1     3    
第三步:    2     1 <-- 3    =>    2     2     2   
示例 2：

输入：machines = [0,3,0]
输出：2
解释：
第一步:    0 <-- 3     0    =>    1     2     0    
第二步:    1     2 --> 0    =>    1     1     1     
示例 3：

输入：machines = [0,2,0]
输出：-1
解释：
不可能让所有三个洗衣机同时剩下相同数量的衣物。
 

提示：

n == machines.length
1 <= n <= 104
0 <= machines[i] <= 105

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/super-washing-machines
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

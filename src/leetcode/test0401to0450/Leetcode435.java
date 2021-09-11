package leetcode.test0401to0450;

import java.util.Arrays;
import java.util.Comparator;

/*给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
示例 1:

输入: [ [1,2], [2,3], [3,4], [1,3] ]

输出: 1

解释: 移除 [1,3] 后，剩下的区间没有重叠。
示例 2:

输入: [ [1,2], [1,2], [1,2] ]

输出: 2

解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
示例 3:

输入: [ [1,2], [2,3] ]

输出: 0

解释: 你不需要移除任何区间，因为它们已经是无重叠的了。

将二维数组进行排序，按先按左坐标比较，大的在前，
之后的区间左下标一定小于或等于当前的左小标。
把第一个区间先当标记坐标，初始化最大存在区间为1，因为不管和第一个区间左坐标相同的区间有多少个，都只能保存一个且其右边一定没有其他区间
找下一个区间第一次出现的右坐标小于当前标记区间的左坐标，区间最大存在数加一，把当前坐标作为标记区间。
*/
public class Leetcode435 {
	public static void main(String[] args) {
		
	}
	
    public int eraseOverlapIntervals2(int[][] intervals) {
    	if(intervals.length <= 1) {
    		return 0;
    	}
    	Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return b[0] - a[0];
            }
        });
    	int end = intervals[0][0];
    	int count = 1;
    	for(int i = 1; i < intervals.length; i++) {
    		if(end >= intervals[i][1]) {
    			count++;
                end = intervals[i][0];
    		}
    	}
    	
    	return intervals.length - count;
    }
	
	
    public int eraseOverlapIntervals(int[][] intervals) {
    	if(intervals.length <= 1) {
    		return 0;
    	}
    	mergeSort(intervals);
    	int end = intervals[0][0];
    	int count = 0;
    	for(int i = 1; i < intervals.length; i++) {
    		if(end >= intervals[i][1]) {
    			end = intervals[i][0];
    		}else {
    			count++;
    		}
    	}
    	
    	return count;
    }
    
    public void mergeSort(int[][] arr) {
		int n = 1;
		while(n<2*arr.length) {
			for(int i = 0;i<arr.length;i+=(2*n)) {
				if(i+n<arr.length) {
					int[][] arr1 = copyArr(arr, i, i+n);
					int[][] arr2 = copyArr(arr, i+n, (i+2*n)<arr.length?(i+2*n):arr.length);
					int k = i;
					int x = 0;
					int y = 0;
					while(x<arr1.length&&y<arr2.length) {
						if(arr1[x][0] > arr2[y][0]) {
							arr[k][0] = arr1[x][0];
							arr[k++][1] = arr1[x++][1];
						}else if(arr1[x][0] == arr2[y][0]){
							if(arr1[x][1]<=arr2[y][1]) {
								arr[k][0] = arr1[x][0];
								arr[k++][1] = arr1[x++][1];
							} else {
								arr[k][0] = arr2[y][0];
								arr[k++][1] = arr2[y++][1];
							}
						}else {
							arr[k][0] = arr2[y][0];
							arr[k++][1] = arr2[y++][1];
						}
					}
					while(x<arr1.length) {
						arr[k][0] = arr1[x][0];
						arr[k++][1] = arr1[x++][1];
					}
					while(y<arr2.length) {
						arr[k][0] = arr2[y][0];
						arr[k++][1] = arr2[y++][1];
					}
				}
			}
			n*=2;
		}
	}
    
    public int[][] copyArr(int[][] arr, int from, int to){
    	int[][] newArr = new int[to-from][2];
    	
    	for(int i = from; i < to; i++) {
    		newArr[i-from][0] = arr[i][0];
    		newArr[i-from][1] = arr[i][1];
    	}
    	
    	return newArr;
    }
}

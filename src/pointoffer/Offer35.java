package pointoffer;

public class Offer35 {
	//时间复杂的太大
	public int InversePairs(int [] array) {
		int counts = 0;
	    for(int i = 1;i<array.length;i++) {
	    	int in = array[i];
	    	boolean flag = false;
	    	for(int j = i-1;j>=0;j--) {
	    		if(array[j]>in) {
	    			counts = (counts+1)%1000000007;
	    			array[j+1] = array[j];
	    		}else{
	    			array[j+1] = in;
	    			flag = true;
	    			break;
	    		}
	    	}
	    	if(!flag) {
	    		array[0] = in;
	    	}
	    }
	    return counts;
	}
	/*
	public int InversePairs(int[] array,int begin,int end){
	    if(begin == end){
	        return 0;
	    }
	    int mid = (begin+end)>>1;
	    int beginCount = InversePairs(array,begin,mid)% 1000000007;
	    int endCount = InversePairs(array, mid+1, end)% 1000000007;
	    int count = 0;
	    int begin1 = begin;
	    int begin2 = mid+1;
	    int[] temp = new int[end-begin+1];
	    int flag = 0;
	    while (begin1 <= mid && begin2 <= end) {
	        if (array[begin1] <= array[begin2]) {
	            temp[flag++] = array[begin1++];
	        } else {
	            temp[flag++] = array[begin2++];
	            count = count + mid - begin1+1;
	            if(count>=1000000007){//数值过大求余
	                count%=1000000007;
	            }
	        }
	    }
	    while (begin1 <= mid) {
	        temp[flag++] = array[begin1++];
	    }
	    while (begin2 <= end) {
	        temp[flag++] = array[begin2++];
	    }
	    for(int k = 0;k<temp.length;k++){
	        array[k+begin] = temp[k];
	    }
	    return count+beginCount+endCount;
	}
	public int InversePairs(int[] array) {
	    if (array.length <= 1) {
	        return 0 % 1000000007;
	    }
	    int count = InversePairs(array, 0, array.length-1);
	    return count % 1000000007;
	}*/
}
/*
题目描述
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
输入描述:
题目保证输入的数组中没有的相同的数字

数据范围：

	对于%50的数据,size<=10^4

	对于%75的数据,size<=10^5

	对于%100的数据,size<=2*10^5

示例1
输入
复制
1,2,3,4,5,6,7,0
输出
复制
7
*/
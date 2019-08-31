package pointoffer;

public class Offer63 {
	int[] nums =  new int[0];
	
	public static void main(String[] args) {
		Offer63 o = new Offer63();
		o.Insert(5);
		System.out.println(o.GetMedian());
		o.Insert(2);
		System.out.println(o.GetMedian());
		o.Insert(3);
		System.out.println(o.GetMedian());
		o.Insert(4);
		System.out.println(o.GetMedian());
		o.Insert(1);
		System.out.println(o.GetMedian());
		
	}
	
	public void Insert(Integer num) {
	    int[] newNums = new int[nums.length+1];
	    int i = 0;
	    int j = 0;
	    while(i<nums.length&&num>nums[i]) {
	    	newNums[j++] = nums[i++];
	    }
	    newNums[j++] = num;
	    while(j<newNums.length) {
	    	newNums[j++] = nums[i++];
	    }
	    nums = newNums;
    }

    public Double GetMedian() {
    	int mid = nums.length/2;
        return nums.length%2==0?(nums[mid-1]+nums[mid])/2d:nums[mid];
    }
}
/*
题目描述
如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值,
那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，
使用GetMedian()方法获取当前读取数据的中位数。
*/
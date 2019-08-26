package pointoffer;

public class Offer37 {
	public int GetNumberOfK(int [] array , int k) {
		int max = array.length-1;
		int min = 0;
		while(min<=max) {
			int mid = (max+min)/2;
			if(array[mid]>k) {
				max = mid-1;
			}else if(array[mid]<k) {
				min = mid+1;
			}else {
				return frontAndBehind(array, k, mid);
			}
		}
		return 0;
    }
	public int frontAndBehind(int[] array,int k,int index) {
		int count = 1;
		for(int i = index+1;i<array.length;i++) {
			if(array[i]==k) {
				count++;
			}else {
				break;
			}
		}
		for(int j = index-1;j>=0;j--) {
			if(array[j]==k) {
				count++;
			}else {
				break;
			}
		}
		return count;
	}
}
/*
题目描述
统计一个数字在排序数组中出现的次数。
*/
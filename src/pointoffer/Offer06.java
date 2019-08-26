package pointoffer;

public class Offer06 {
	public int minNumberInRotateArray(int [] array) {
		if(array.length==0) {
			return 0;
		}
		int min = 0;
		int max = array.length-1;
		if (array.length == 1||array[0] < array[max]) {
            return array[0];
        }
		while(min<max) {//二分法
			int mid = (max+min)/2+1;
			if(array[mid+1]<array[mid]) {
				return array[mid+1];
			}
			if(array[mid]>array[0]) {
				min = mid;
			}else if(array[mid]<array[0]){
				max = mid;
			}else {
				//特殊情况
				//2,1,2,2,2,2,2,2
				//2,2,2,2,2,2,1,2
				//所以相等时只能让max--
				max--;
			}
		}
		return array[min];
    }
}
/*
 * 题目描述 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
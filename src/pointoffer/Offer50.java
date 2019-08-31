package pointoffer;

public class Offer50 {
	public static void main(String[] args) {
		boolean[] a = new boolean[2];
		System.out.println(a[0]);
	}
    public boolean duplicate(int numbers[],int length,int [] duplication) {
    	boolean[] temp = new boolean[length];
        for(int i = 0;i<length;i++){
        	if(temp[numbers[i]] == true) {
        		duplication[0] = numbers[i];
        		return true;
        	}
            temp[numbers[i]]=true;
        }
        return false;
    }
}
/*\;
题目描述
在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 数组中某些数字是重复的，但不知道有几个数字是重复的。
 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 
 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 那么对应的输出是第一个重复的数字2。
*/
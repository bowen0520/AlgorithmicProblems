package pointoffer;

import java.util.Arrays;

public class Offer13 {
	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7};
		new Offer13().reOrderArray(array);
		System.out.println(Arrays.toString(array));
	}
	
	/*
	public void reOrderArray(int [] array) {
		int i = 0;
		for(;i<array.length;i++) {
			if(array[i]%2==0) {
				break;
			}
		}
		int count = array.length-i;
		for(int j = array.length-1;j>i;) {
			if(count!=0&&array[j]%2==1){
				int temp = array[j];
				for(int k = j;k>i;k--) {
					array[k] = array[k-1];
				}
				array[i] = temp;
			}else {
				j--;
			}
			count--;
		}
    }
    */
	// 0 1 2 3 4 5 6 7 8
	/*
	 public void reOrderArray(int [] array) {
	        int count = 0;
	        for(int i = 0;i<array.length;i++){
	            if(array[i]%2!=0){
	                int a = array[i];
	                for(int j = count++;j<=i;j++){
	                    int b = array[j];
	                    array[j]=a;
	                    a = b;
	                }
	            }
	        }
	    }
	 */
	public void reOrderArray(int [] array) {
		int size = 2;
		while(size<array.length*2) {
			for(int i = 0;i<array.length;i+=size) {
				help(array, i, size);
			}
			size*=2;
		}
    }
	
	public void help(int[] array,int index,int size) {
		int mid = (index+index+size)/2;
		int end = index+size-1;
		
		int[] temp1;
		if(mid<array.length) {
			temp1 = new int[size/2];
			for(int i = index;i<mid;i++) {
				temp1[i-index] = array[i];
			}
		}else {
			return ;
		}
		
		int[] temp2;
		if(end<array.length) {
			temp2 = new int[size/2];
			for(int i = mid;i<=end;i++) {
				temp2[i-mid] = array[i];
			}
		}else {
			end = array.length-1;
			temp2 = new int[array.length-mid];
			for(int i = mid;i<=end;i++) {
				temp2[i-mid] = array[i];
			}
		}
		
		int in = index;
		int x = 0;
		int y = 0;
		
		for(;x<temp1.length;) {
			if(temp1[x]%2 == 1) {
				array[in] = temp1[x];
				in++;
				x++;
			}else {
				break;
			}
		}
		for(;y<temp2.length;) {
			if(temp2[y]%2 == 1) {
				array[in] = temp2[y];
				in++;
				y++;
			}else {
				break;
			}
		}
		
		for(;x<temp1.length;x++) {
			array[in] = temp1[x];
			in++;
		}
		for(;y<temp2.length;y++) {
			array[in] = temp2[y];
			in++;
		}
	}
}
/*
 * 题目描述 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，
 * 偶数和偶数之间的相对位置不变。
 */
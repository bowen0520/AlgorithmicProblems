package pointoffer;

import java.util.Arrays;

public class Offer23 {
	public static void main(String[] args) {
		int[] nums = {1,3};
		System.out.println(new Offer23().VerifySquenceOfBST(nums));
	}
	/*
	public boolean VerifySquenceOfBST(int [] sequence) {
		if(sequence.length==0) {
			return false;
		}
	    return VerifySquenceOfBST(sequence, 0, sequence.length-1);
	}
	public boolean VerifySquenceOfBST(int [] sequence,int start,int end) {
	    if(Math.abs(end-start)<=1) {
	    	return true;
	    }
	    int t = sequence[end];
	    int i = start;
	    for(;i<end;i++) {
	    	if(sequence[i]>t) {
	    		break;
	    	}
	    }
	    int j = i;
	    for(;j<end;j++) {
	    	if(sequence[j]<t) {
	    		return false;
	    	}
	    }
	    return VerifySquenceOfBST(sequence, start, i-1)&&VerifySquenceOfBST(sequence, i, end-1);
	}*/
	
	public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length==0){
            return false;
        }
        int mid = sequence.length-1;
        for(int i = 0;i<sequence.length-1;i++){
            if(sequence[i]>sequence[sequence.length-1]){
                mid = i;
                break;
            }
        }
        for(int i = mid+1;i<sequence.length-1;i++){
            if(sequence[i]<sequence[sequence.length-1]){
                return false;
            }
        }
        boolean left=true;
        boolean right=true;
        if(mid>0){
            left=VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, mid));
        }
        if(mid<sequence.length-1)
            right=VerifySquenceOfBST(Arrays.copyOfRange(sequence, mid, sequence.length-1));
        return (left&&right);
    }
}
/*
题目描述
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
*/
package leetcode.test1001to1050;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        int n = 0;
        List<Boolean> list = new ArrayList<Boolean>();
        for(int i = 0; i < A.length; i++){
            n =  n + A[i] * (int)Math.pow(2, i);
            list.add(n%5 == 0);
        }
        return list;
    }
    public static void main(String[] args) {
		int a = 1;
		System.out.println(a<<1);
	}
}

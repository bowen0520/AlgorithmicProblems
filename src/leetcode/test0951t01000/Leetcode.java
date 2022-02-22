package leetcode.test0951t01000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> an = new ArrayList();

        for(int i = arr.length; i > 0; i--){
            int maxIDX = 0;
            for(int j = 1; j < i; j++){
            	if(arr[j] > arr[maxIDX]) {
            		maxIDX = j;
            	}
            }
            
            an.add(maxIDX + 1);
            an.add(i);
            sort(arr, maxIDX, i);
        }

        return an;
    }

    public void sort(int[] arr, int maxIDX, int end){
        int[] tmp = Arrays.copyOfRange(arr, 0, end);
        
        int arrIDX = 0;
        for(int i = end - 1; i > maxIDX; i--) {
        	arr[arrIDX++] = tmp[i];
        }
        for(int i = 0; i < maxIDX; i++) {
        	arr[arrIDX++] = tmp[i];
        }
        arr[arrIDX++] = tmp[maxIDX];
    }
}

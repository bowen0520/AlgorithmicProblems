package interviewquestions.tenxun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for(int j = 0;j<x;j++) {
				list.add(y);
			}
		}
		
		
		
		int min = Integer.MAX_VALUE;
		int len = list.size();
		for(int k = 0;k<len/2;k++) {
			int an = list.get(k)+list.get(len-k-1);
			if(an<min) {
				min = an;
			}
		}
		list.forEach(System.out::println);
		System.out.println(min);

	}
}

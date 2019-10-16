package interviewquestions.tenxun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Test3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int hand = sc.nextInt();
		List<Integer> que = new ArrayList<Integer>();
		Set<Integer> set= new HashSet<>();
		for(int i = 0;i<num;i++) {
			int n = sc.nextInt();
			if(n!=0&&!set.contains(n)) {
				que.add(n);
				set.add(n);
			}
		}
		Collections.sort(que);
		int sum = 0;
		for(int j = 0;j<hand;j++) {
			if(j>=que.size()) {
				System.out.println(0);
			}else {
				System.out.println(que.get(j)-sum);
				sum = que.get(j);
			}
		}
	}

}

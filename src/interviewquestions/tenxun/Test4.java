package interviewquestions.tenxun;

import java.util.Scanner;

public class Test4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int[] a = new int[num];
		int[] b = new int[num];
		
		for(int i = 0;i<num;i++) {
			a[i] = sc.nextInt();
		}
		
		for(int j = 0;j<num;j++) {
			b[j] = sc.nextInt();
		}
		
		int[] c = new int[num*num];
		
		for(int x = 0;x<num;x++) {
			for(int y = 0;y<num;y++) {
				c[x*num+y] = a[x]+b[y];
			}
		}
		
		int an = c[0];
		for(int k = 1;k<c.length;k++) {
			an = an^c[k];
		}
		
		System.out.println(an);
	}

}

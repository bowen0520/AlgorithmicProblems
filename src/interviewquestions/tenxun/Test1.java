package interviewquestions.tenxun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0;i<n;i++) {
			int len = Integer.parseInt(br.readLine());
			String num = br.readLine();
			int index = num.indexOf('8');
			if(len<11||index==-1) {
				System.out.println("NO");
			}else {
				if(len-index>=11) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}

}

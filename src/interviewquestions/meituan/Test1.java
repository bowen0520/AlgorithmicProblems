package interviewquestions.meituan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String str = new String(s);
		
		Map<String,String> map = new HashMap<String, String>();
		
		if(s.length()>2) {
			String[] ss = s.substring(1, s.length()-1).split(",");
			for(int i = 0;i<ss.length;i++) {
				String temp = ss[i].substring(1, ss[i].length()-1);
				String newTemp = get(temp);
				str.replaceAll(temp, newTemp);
			}
			System.out.println(str);
		}else {
			System.out.println(str);
		}
	}
	
	public static String get(String s) {
		return s;
	}
}

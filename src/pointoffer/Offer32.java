package pointoffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Offer32 {
	public String PrintMinNumber(int [] numbers) {
		List<String> list = new ArrayList<String>();
		for(int n:numbers) {
			list.add(n+"");
		}
		
		//list.sort((o1,o2)->{return (o1+o2).compareTo(o2+o1);});
		
		list.sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				String s1 = o1+o2;
				String s2 = o2+o1;
				return s1.compareTo(s2);
			}
		});
		
		StringBuilder stringBuilder = new StringBuilder();
		list.forEach(stringBuilder::append);
		return stringBuilder.toString();
    }
}
/*
题目描述
输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
*/
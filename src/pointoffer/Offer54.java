package pointoffer;

import java.util.LinkedList;
import java.util.List;

public class Offer54 {
	
	public static void main(String[] args) {
		Offer54 o = new Offer54();
		o.Insert('a');
		System.out.println(o.FirstAppearingOnce());
		o.Insert('b');
		System.out.println(o.FirstAppearingOnce());
		o.Insert('a');
		System.out.println(o.FirstAppearingOnce());
		o.Insert('c');
		System.out.println(o.FirstAppearingOnce());
	}
	
	
	int[] books = new int[256];
	List<Character> list = new LinkedList<Character>();
	String an = "";
	public void Insert(char ch){
		books[ch]++;
		if(books[ch]==1) {
			list.add(ch);
		}
		if(books[ch]==2) {
			remove(ch);
		}
    }
	private void remove(char ch) {
		for(int i = 0;i<list.size();i++) {
			if(list.get(i)==ch) {
				list.remove(i);
				break;
			}
		}
	}
//return the first appearence once char in current stringstream
    public char FirstAppearingOnce(){
    	return list.size()==0?'#':list.get(0);
    }
}
/*
题目描述
请实现一个函数用来找出字符流中第一个只出现一次的字符。
例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
输出描述:
如果当前字符流没有存在出现一次的字符，返回#字符。
*/
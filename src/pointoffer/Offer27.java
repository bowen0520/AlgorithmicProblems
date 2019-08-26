package pointoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Offer27 {
	public static void main(String[] args) {
		String s = "bb";
		ArrayList<String> strList = new Offer27().Permutation(s);
		System.out.println(strList.size());
		strList.forEach(System.out::println);
	}
	/*public ArrayList<String> Permutation(String str) {
		ArrayList<String> strList = new ArrayList<String>();
		char[] cs = str.toCharArray();
		if(cs.length==0) {
			return strList;
		}
		List<Character> list = new ArrayList<Character>();
		for(char c:cs) {
			list.add(c);
		}
		Set<String> set = new HashSet<String>();
		help(list,"",set);
		strList.addAll(set);
		Collections.sort(strList);
		return strList;
	}
	
	public void help(List<Character> list,String str,Set<String> set) {
		if(list.size()==0) {
			set.add(str);
			return ;
		}
		for(int i = 0;i<list.size();i++) {
			char c = list.get(i);
			String strT = str+c;
			list.remove(i);
			List<Character> temp = new ArrayList<Character>(list);
			help(temp,strT,set);
			list.add(i, c);
		}
	}*/
	
	
	/*public ArrayList<String> Permutation(String str) {
	    if(str.isEmpty()){
	        return new ArrayList<String>();
	    }
	    ArrayList<String> list = new ArrayList<String>(getList(str));
	    Collections.sort(list);
	    return list;
	}
	 
	public Set<String> getList(String str) {
	    Set<String> set = new HashSet<String>();
	    if(str.length()==1){
	        set.add(str);
	        return set;
	    }
	    Set<String> oldSet = getList(str.substring(1));
	    char first = str.charAt(0);
	    oldSet.forEach((o)->{
	    	for(int j = 0;j<=o.length();j++){
	            String s = j==0?first+o:(j==o.length()?o+first:o.substring(0, j)+first+o.substring(j));
	    		set.add(s);
	        }
	    });
	    return set;
	}*/
    
    
	
	public ArrayList<String> Permutation(String str) {
	    ArrayList<String> list = new ArrayList<String>();
	    if(str.isEmpty()){
	        return list;
	    }
	    help(str.toCharArray(),0,list);
	    Collections.sort(list);
	    return list;
	}
	public void help(char[] chars,int index,ArrayList<String> list){
	    if(index==chars.length-1){
	        if(!list.contains(String.valueOf(chars)))
	        list.add(String.valueOf(chars));
	        return;
	    }
	    for(int i = index;i<chars.length;i++){
	        swap(chars, index, i);
	        help(chars, index+1, list);
	        swap(chars, index, i);
	    }
	}
	public void swap(char[] chars,int i,int j){
	    char temp  = chars[i];
	    chars[i] = chars[j];
	    chars[j] = temp;
	}
	
}
/*
题目描述
输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
输入描述:
输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
*/
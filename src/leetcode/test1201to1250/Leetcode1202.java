package leetcode.test1201to1250;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。

你可以 任意多次交换 在 pairs 中任意一对索引处的字符。

返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。

 

示例 1:

输入：s = "dcab", pairs = [[0,3],[1,2]]
输出："bacd"
解释： 
交换 s[0] 和 s[3], s = "bcad"
交换 s[1] 和 s[2], s = "bacd"
示例 2：

输入：s = "dcab", pairs = [[0,3],[1,2],[0,2]]
输出："abcd"
解释：
交换 s[0] 和 s[3], s = "bcad"
交换 s[0] 和 s[2], s = "acbd"
交换 s[1] 和 s[2], s = "abcd"
示例 3：

输入：s = "cba", pairs = [[0,1],[1,2]]
输出："abc"
解释：
交换 s[0] 和 s[1], s = "bca"
交换 s[1] 和 s[2], s = "bac"
交换 s[0] 和 s[1], s = "abc"
 

提示：

1 <= s.length <= 10^5
0 <= pairs.length <= 10^5
0 <= pairs[i][0], pairs[i][1] < s.length
s 中只含有小写英文字母

 */
public class Leetcode1202 {
	//错误
    public String smallestStringWithSwapsError(String s, List<List<Integer>> pairs) {
        boolean book = true;
        char[] cs = s.toCharArray();
        while(book) {
        	book = false;
        	
        	for(List<Integer> list:pairs) {
        		int ins = list.get(0);
        		int ine = list.get(1);
        		
        		if(cs[ins] > cs[ine]) {
        			char temp = cs[ins];
        			cs[ins] = cs[ine];
        			cs[ine] = temp;
        			book = true;
        		}
        	}
        }
        
        return String.valueOf(cs);
    }
    
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        boolean book = true;
        char[] cs = s.toCharArray();
        boolean[] csbook = new boolean[cs.length];
        while(book) {
        	
        	Set<Integer> set = new HashSet<Integer>();
        	boolean first = true;
        	for(List<Integer> list:pairs) {
        		int ins = list.get(0);
        		int ine = list.get(1);
        		
        		if(!csbook[ins] && first) {
        			set.add(ins);
        			set.add(ine);
        			first = false;
        		}
        		
        		if(!csbook[ins] && set.contains(ins)) {
        			set.add(ine);
        		}
        		if(!csbook[ine] && set.contains(ine)) {
        			set.add(ins);
        		}
        	}
        	
        	if(set.isEmpty()) {
        		book = false;
        		break;
        	}
        	
        	List<Character> list = new ArrayList<Character>();
        	for(int i = 0; i < cs.length; i++) {
        		if(!csbook[i] && set.contains(i)) {
        			list.add(cs[i]);
        		}
        	}
        	
        	list.sort(new Comparator<Character>() {

				@Override
				public int compare(Character o1, Character o2) {
					// TODO Auto-generated method stub
					return o2 - o1;
				}
			});
        	
        	int in = 0;
        	for(int i = 0; i < cs.length; i++) {
        		if(!csbook[i] && set.contains(i)) {
        			cs[i] = list.get(in++);
        			csbook[i] = true;
        		}
        	}
        }
        
        return String.valueOf(cs);
    }
}

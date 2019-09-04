package competition.oneweekrace.oneweekrace152;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.print.attribute.HashAttributeSet;

public class Test3 {
	public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		List<Boolean> list = new ArrayList<Boolean>();
        for(int i = 0;i<queries.length;i++) {
        	String str = s.substring(queries[i][0], queries[i][1]+1);
        	list.add(check(str,queries[i][2]));
        }
        return list;
    }
	public boolean check(String str,int n) {
		char[] ss = str.toCharArray();
		boolean[] books = new boolean[26];
		int len = 0;
		for(int i = 0;i<ss.length;i++) {
			int index = ss[i]-'a';
			if(books[index]) {
				books[index] = false;
				len--;
			}else{
				books[index] = true;
				len++;
			}
		}
		return len-1<=2*n;
	}
}

package leetcode.test0401to0450;

import java.util.HashMap;
import java.util.Map;

public class Leetcode423 {
    public String originalDigits2(String s) {
        Map<Character, Integer> c = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            c.put(ch, c.getOrDefault(ch, 0) + 1);
        }

        int[] cnt = new int[10];
        cnt[0] = c.getOrDefault('z', 0);
        cnt[2] = c.getOrDefault('w', 0);
        cnt[4] = c.getOrDefault('u', 0);
        cnt[6] = c.getOrDefault('x', 0);
        cnt[8] = c.getOrDefault('g', 0);

        cnt[3] = c.getOrDefault('h', 0) - cnt[8];
        cnt[5] = c.getOrDefault('f', 0) - cnt[4];
        cnt[7] = c.getOrDefault('s', 0) - cnt[6];

        cnt[1] = c.getOrDefault('o', 0) - cnt[0] - cnt[2] - cnt[4];

        cnt[9] = c.getOrDefault('i', 0) - cnt[5] - cnt[6] - cnt[8];

        StringBuffer ans = new StringBuffer();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                ans.append((char) (i + '0'));
            }
        }
        return ans.toString();
    }
	
	Map<Character, Integer> map = new HashMap<Character, Integer>();
	
	public String originalDigits(String s) {
    	String[] strA = new String[10];
        for(char c: s.toCharArray()) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //count 6 six x
        strA[6] = help("six", 'x', 6);
        //count 7 seven s
        strA[7] = help("seven", 's', 7);
        //count 0 zero z
        strA[0] = help("zero", 'z', 0);
        //count 2 two w
        strA[2] = help("two", 'w', 2);
        //count 8 eight g
        strA[8] = help("eight", 'g', 8);
        //count 5 five v
        strA[5] = help("five", 'v', 5);
        //count 4 four f
        strA[4] = help("four", 'f', 4);
        //count 3 three t
        strA[3] = help("three", 't', 3);
        //count 1 one o
        strA[1] = help("one", 'o', 1);
        //count 9 nine i
        strA[9] = help("nine", 'i', 9);
        
        String an = "";
        for(int i = 0; i < strA.length; i++) {
        	an = an + strA[i];
        }
        
        return an;
    }
    
    public String help(String str, char key, int num) {
        int len = map.getOrDefault(key, 0);
        String an = "";
        if(len != 0) {
        	 for(char c: str.toCharArray()) {
        		 map.put(c, map.get(c) - len);
        	 }
        	 
        	 for(int j = 0 ; j < len; j++) {
        		 an = an + num;
        	 }
        }
        return an;
    }
}

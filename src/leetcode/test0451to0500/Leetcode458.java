package leetcode.test0451to0500;

import java.util.HashMap;
import java.util.Map;

import javax.accessibility.AccessibleStreamable;

public class Leetcode458 {
	Map<String, Integer> book = new HashMap<String, Integer>();
	
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest/minutesToDie;
        int an = 0;
        while(true) {
        	
        	if(help(an, times) >= buckets) {
        		break;
        	}
        	
        	an++;
        }
        return an;
    }
    
    public int help(int pig, int count) {
        String key = pig + " " + count;
        
        if(book.containsKey(key)) {
        	return book.get(key);
        }
        
        int an = 0;
        
        if(pig == 0) {
        	an = 1;
        }else if(pig == 1){
			an = count + 1;
		}else if (count == 1) {
			an = pig * 2;
		}else {
			an = (pig - 1) * help(pig - 2, count - 1) + pig * help(pig - 1, count - 1) + help(pig, count - 1);
		}
        System.out.println(key + " " + an);
        book.put(key, an);
        return an;
        
    }
    
    public static void main(String[] args) {
    	Leetcode458 leetcode458 = new Leetcode458();
    	
    	System.out.println(leetcode458.poorPigs(1000, 12, 60));
	}
}

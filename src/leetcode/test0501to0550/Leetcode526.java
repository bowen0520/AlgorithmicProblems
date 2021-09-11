package leetcode.test0501to0550;

public class Leetcode526 {
	public static void main(String[] args) {
		System.out.println(countArrangement(4));
	}
	
    public static int countArrangement(int n) {
        boolean[] book = new boolean[n];
        
        return countArrangement(1, book);
    }
    
    public static int countArrangement(int idx, boolean[] book) {
        int an = 0;
        if(idx > book.length) {
        	return 1;
        }
        
        for(int i = 1; i <= book.length; i++) {
        	if(!book[i-1] && (i%idx == 0 || idx%i == 0)) {
        		book[i-1] = true;
        		an += countArrangement(idx+1, book);
        		book[i-1] = false;
        	}
        }
        return an;
    }
}

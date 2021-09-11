package face;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Face13 {
	public static void main(String[] args) {
		String s = "新年快乐";
		int a = 520;
		for(byte b: s.getBytes()) {
			a = a ^ b;
			
		}
		a = a ^ 520;
		System.out.println(a);
		System.out.println(Integer.toBinaryString(a));
		int a1 = 1000000007;
	
	
	}
    public int movingCount(int m, int n, int k) {
    	boolean[][] book = new boolean[m][n];
    	book[0][0] = true;
    	
    	return movingCount(m, n, k, book, 0, 0);
    }
    
    public int movingCount(int m, int n, int k, boolean[][] book, int x, int y) {
    	int sum = 0;
    	if(x-1>=0 && !book[x-1][y] && getHe(x-1, y)<=k) {
    		book[x-1][y] = true;
    		sum += movingCount(m,n,k,book,x-1,y);
    	}
    	
    	if(x+1<m && !book[x+1][y] && getHe(x+1, y)<=k) {
    		book[x+1][y] = true;
    		sum += movingCount(m,n,k,book,x+1,y);
    	}
    	
    	if(y-1>=0 && !book[x][y-1] && getHe(x, y-1)<=k) {
    		book[x][y-1] = true;
    		sum += movingCount(m,n,k,book,x,y-1);
    	}
    	
    	if(y+1<n && !book[x][y+1] && getHe(x, y+1)<=k) {
    		book[x][y+1] = true;
    		sum += movingCount(m,n,k,book,x,y+1);
    	}
    	
    	return sum + 1;
    }
    
    public int getHe(int x, int y) {
    	int sum = 0;
    	while(x != 0) {
    		sum += x%10;
    		x = x/10;
    	}
    	while(y != 0) {
    		sum += y%10;
    		y = y/10;
    	}
    	return sum;
    }
}

package leetcode.test0651to0700;

public class Leetcode684 {

	
    public int[] findRedundantConnectionError(int[][] edges) {
        boolean[] book = new boolean[edges.length+1];
        int p = 0;
        int b = 0;
        int l = 0;
        for(int[] edge:edges) {
            if(!(book[edge[0]] || book[edge[1]])) {
        		book[edge[0]] = true;
                book[edge[1]] = true;
                p++;
                p++;
                l++;
        	}else if(!book[edge[0]]) {
        		book[edge[0]] = true;
                p++;
        	}else if(!book[edge[1]]) {
        		book[edge[1]] = true;
                p++;
        	}else{
                l = (l==1?1:l-1);
            }
            b++;

            if(p <= (b + l - 1)){
                return edge;
            }
        }
        
        return new int[2];
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        int color = 1;
        int[] book = new int[edges.length + 1];
        
        for(int[] edge:edges) {
            if(book[edge[0]] != 0 && book[edge[1]] != 0) {
            	if(book[edge[0]] == book[edge[1]]) {
            		return edge;
            	}else {
            		putColor(book, book[edge[1]], book[edge[0]]);
            	}
            }else if(book[edge[0]] != 0) {
        		book[edge[1]] = book[edge[0]];
        	}else if(book[edge[1]] != 0) {
        		book[edge[0]] = book[edge[1]];
        	}else {
        		book[edge[0]] = color;
        		book[edge[1]] = color;
        		color++;
        	}
        }
        return new int[2];
    }
    
    public void putColor(int[] book, int oldColor, int color) {
		for(int i = 0; i < book.length; i++) {
			if(book[i] == oldColor) {
				book[i] = color;
			}
		}
	}
    public static void main(String[] args) {
		int[] a = new int[1];
	}
}

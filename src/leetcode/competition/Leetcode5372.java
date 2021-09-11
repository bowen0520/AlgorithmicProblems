package leetcode.competition;

public class Leetcode5372 {
    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for(int i = 0;i < nums.length;i++) {
        	sum += nums[i];
        	if(sum < min) {
        		min = sum;
        	}
        }
        
        return min >= 0? 1:-min + 1;
        
    }
    
    
    public int findMinFibonacciNumbers(int k) {
    	if(k<= 3) {
    		return 1;
    	}
        int[] book = new int[k+1];
        
        int a = 1;
        int b = 1;
        for(;b<=k;) {
        	book[b] = 1;
        	int temp = a + b;
        	a = b;
        	b = temp;
        }
        int n = 0;
        
        while(k != 0) {
        	for(int j = k;j>=0;j--) {
        		if(book[j] == 1) {
        			n++;
        			k -= j;
        			break;
        		}
        	}
        }
        
        return n;
    }
    
    
    public String getHappyString(int n, int k) {
        int num = 3;
        for(int i = 1;i<n;i++) {
        	num = num * 2;
        }
        
        if(num<k) {
        	return "";
        }
        
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        num = num/3;
        if(num*2<k) {
        	c = 'c';
        	k = k - num*2;
        }else if(num<k) {
        	c = 'b';
        	k = k - num;
        }else {
        	c = 'a';
        }
        
        sb.append(c);
        for(;num>1 && k>0;) {
            num = num/2;
        	if(k>num) {
        		c = getMax(c);
        		k = k-num;
        	}else {
        		c = getMin(c);
        	}
        	sb.append(c);
        }
        return sb.toString();
    }
    
    
    public char getMin(char c) {
    	if(c=='a') {
    		return 'b';
    	}else if(c=='b') {
    		return 'a';
    	}else {
    		return 'a';
    	}
    }
    public char getMax(char c) {
    	if(c=='a') {
    		return 'c';
    	}else if(c=='b') {
    		return 'c';
    	}else {
    		return 'b';
    	}
    }
}

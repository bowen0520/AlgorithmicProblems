package pointoffer;

public class Offer31 {
	
	public static void main(String[] args) {
		new Offer31().NumberOf1Between1AndN_Solution(1);
	}
	
	public int NumberOf1Between1AndN_Solution(int n) {
        if(n<=0){
            return 0;
        }
        int count = 0;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=i;j*=10){
                int temp = i/j;
                if(temp%10==1){
                    count++;
                }
            }
        }
        return count;
    }
	
	/*
	public int NumberOf1Between1AndN_Solution(int n) {
	    int count = 0;
	    for(int i = 1;i<=n;i*=10) {
	    	int x = n/i;
	    	int y = n%i;
	    	if(x%10==0) {
	    		count = count + (x/10)*i;
	    	}else if(x%10==1) {
	    		count = count + (x/10)*i+y+1;
	    	}else {
	    		count = count + (x/10+1)*i;
	    	}
	    }
	    System.out.println(count);
	    return count;
	}*/
}
/*
题目描述
求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,但是对于后面问题他就没辙了。
ACMer希望你们帮帮他,并把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
*/
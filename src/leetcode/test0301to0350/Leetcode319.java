package leetcode.test0301to0350;

public class Leetcode319 {
	
    public int bulbSwitch(int n) {
        int an = 0;
        do {
        	an++;
        }while(an * an <= n);
        return an - 1;
    }
    public int bulbSwitch2(int n) {
        if(n == 1 || n == 2 || n == 3){
            return 1;
        }
        int num = (int)Math.sqrt(n);
        boolean flag = num * num == n  ;
        return bulbSwitch2(n-1) + (flag?1:0);
    }
}

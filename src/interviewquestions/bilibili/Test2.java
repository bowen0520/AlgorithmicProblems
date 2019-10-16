package interviewquestions.bilibili;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        long len = 2;
        int count = 1;
        boolean flag = true;
        while(flag){
            long x = (2*n+len-len*len)/(2*len);
            long k = ((x+x+len-1)*len)/2;
            if(x<=0){
                flag = false;
                break;
            }
            if(k == n){
                count++;
            }
            len++;
        }
        System.out.println(count);
    }
}

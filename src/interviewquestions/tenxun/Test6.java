package interviewquestions.tenxun;

import java.util.Scanner;

public class Test6 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int an = getSameCounts(s1.toCharArray(),0,s2.toCharArray(),0);
        System.out.println(an);
    }

    public static int getSameCounts(char[] sot,int index1,char[] lg, int index2){
        if(index1==sot.length||index2==lg.length){
            return sot.length-index1+lg.length-index2;
        }
        int n;
        if(sot[index1]==lg[index2]){
            n = getSameCounts(sot,index1+1,lg,index2+1);
        }else{
            int x = getSameCounts(sot,index1+1,lg,index2+1)+1;
            int y = getSameCounts(sot,index1+1,lg,index2)+1;
            int z = getSameCounts(sot,index1,lg,index2+1)+1;
            n = Math.min(x,Math.min(y,z));
        }
        return n;
    }
}

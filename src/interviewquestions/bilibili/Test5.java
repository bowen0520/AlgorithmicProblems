package interviewquestions.bilibili;

import java.util.*;

public class Test5 {

  public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    List<PerNum> list= new ArrayList<>(100000);
    int t = Integer.parseInt(sc.nextLine());
    for(int i = 0; i < t; i++){
      String[] s = sc.nextLine().split(" ");
      int n1 = Integer.parseInt(s[0]);
      int n2 = Integer.parseInt(s[1]);
      list.add(new PerNum(n1,n2));
    }
    Collections.sort(list);
    System.out.println(minTime(list));
  }
  
  public static int minTime(List<PerNum> list){
    int i=0,j=list.size()-1;
    int min=0;
    boolean flag=false;
    boolean add1=false;
    boolean add2=false;
    int a=0,b=0;
    while (i<=j&&i<list.size()&&j>=0){
      PerNum big = list.get(j);
      PerNum small = list.get(i);
      if(big.k>0){
        a=big.v;
        big.k--;
        add1=true;
      }
      if(small.k>0){
        b=small.v;
        small.k--;
        add2=true;
      }
      if(add1&&add2){
        if(!flag)
          min=a+b;
        else{
          if((a+b)>min)
            min=a+b;
        }
        add1=false;
        add2=false;
      }

      if(big.k<=0)
        j--;
      if(small.k<=0)
        i++;
    }
    return min;
  }
}

class PerNum implements Comparable<PerNum>{
  public int k;
  public int v;
  PerNum(int k,int v){
    this.k=k;
    this.v=v;
  }

  @Override
  public int compareTo(PerNum o) {
    return v-o.v;
  }

  @Override
  public String toString() {
    return "["+k+","+v+"]";
  }
}

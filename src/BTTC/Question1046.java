package BTTC;

import java.util.Scanner;

public class Question1046 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
        while(s.hasNext()) {
            int X = s.nextInt();
            int Y = s.nextInt();
            int S = s.nextInt();
            int T = Math.abs(X)+Math.abs(Y);
            if (S < T) {//不能小于最短时间
                System.out.println("No");
            } else {
                if((S-T)%2==0){//多出来的时间不能是奇数，因为如果走反了肯定是要回来的，要不不能到达
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
                
            }
        }
	}
}
/*
题目描述
两只Bug相爱了，然后他们开始了约会……
开始的时候，一只bug A在平面直角坐标系的原点(0,0)，另一只bug B在(x,y)点。
Bug A 的心情急切，但是Bug们不会微信共享位置信息，所以急切的Bug A 开始爬行着四处寻找Bug B。
Bug A 每一秒只能在平面直角坐标系的四个方向上爬行一个单位距离，而且Bug A是路痴，他会忘记自己爬过的路，
所以他可能会走回头路，但无论怎么爬，他遵循的爬行规则不变。
经过好久之后，Bug A终于到达了(x,y)点找到了Bug B。Bug A对Bug B说我爬了S秒才找到你！
其实S秒可能是bug A虚报的，因为他已经忘记自己爬了多久。但是Bug B很聪明，她一眼就能看出bug
A说的话到底假不假。如果Bug A说的话是假的，那么Bug B就会对他说No，否则才会说Yes。那么Bug B是如何判断的呢？

输入格式

输入数据包括三个整数X、Y、S分别代表Bug B所在位置的横坐标、纵坐标以及Bug A所说的爬行时间。
三个数以空格分隔。(-10^9<=X、Y<=10^9，1<=S<=2*10^9)

输出格式

如果Bug A说的话是假的，输出No，否则输出Yes。每次输出占一行。

输入样例

2 2 4
0 5 1

输出样例

Yes
No
*/

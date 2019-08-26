package BTTC;

import java.util.Scanner;

public class Question1050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			while(sc.hasNext()) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] nums = new int[n];
			int sum = 0;
			for(int i = 0;i < n;i++) {
				nums[i] = sc.nextInt();
				sum += nums[i];
			}
			int ave = sum/k;
			int teams[] = new int[k];
			int j = 0;
			for(int i = 0;i < n;i++) {
				if(Math.abs(ave-teams[j])<Math.abs(ave-teams[j]-nums[i])) {
					j++;
				}
				teams[j] = teams[j]+nums[i];
			}
			int min = Integer.MAX_VALUE;
			for(int t:teams) {
				if(t<min) {
					min = t;
				}
			}
			System.out.println(min);
		}
	}
}
/*
题目描述
有n个同学一起去探险,现在把n个同学分成k个小组,每个小组完成一项探险任务。
分组时,如果第i人与第j人分在同一组(i<j),则他们之间的所有人(第i+1,i+2,…,j-1个)也必须在同一个小组中。
一个小组内所有人的体力和越小，途中可能越危险。为了确保每个同学的安全，要求分组时，使得所有小组中，
体力和最小的那个小组的所有人的体力和尽量大。依次告诉你每个人的体力，如何分组呢？

输入格式

第1行有二个正整数n和k，互相之间以一个空格分隔。
第2行有n个正整数(互相以一个空格分隔)，表示n个人的体力值。其中第j个整数表示第j个人的体力值。
1≤n≤30000,1≤k≤1000, k≤n,每个人的体力值不大于10000

输出格式

只有一个整数,表示最佳划分方案中，最弱的小组中，所有人的体力值之和。

输入样例

5 2
5 2 1 6 9

6 2
5 2 1 6 9 4

输出样例

9
*/

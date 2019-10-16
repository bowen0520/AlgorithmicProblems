package interviewquestions.bilibili;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import java.util.Set;

public class Test1 {
	/*public static void main(String[] args){
	    Scanner sc = new Scanner(System.in);
	    while(sc.hasNext()) {
	        Map<String,Set<String>> map = new HashMap<String, Set<String>>();
	        
	        int num = Integer.parseInt(sc.nextLine());
	        
	        for(int i = 0;i<num;i++) {
	        	map.put(i+"", new HashSet<String>());
	        }
	        
	        String me = sc.nextLine();
	        
	        int count = Integer.parseInt(sc.nextLine());
	        
	        for(int j = 0;j<count;j++){
	            String msg = sc.nextLine();
	            String[] ss = msg.split(",");
	            map.get(ss[0]).add(ss[1]);
	            map.get(ss[1]).add(ss[0]);
	        }
	        
	        Queue<String> que = new ArrayDeque<String>();
	        
	        Set<String> myset = map.get(me);
	        
	        int oldnums = myset.size();
	        
	        que.addAll(myset);
	        
	        while(!que.isEmpty()) {
	        	String s = que.poll();
	        	Set<String> set = map.get(s);
	        	for(String o:set){
	        		if(!myset.contains(o)&&!o.equals(me)) {
	        			myset.add(o);
	        			que.offer(o);
	        		}
	        	}
	        }
	        
	        System.out.println(myset.size()-oldnums);
	    }
	}*/
	
	/*public static void main(String[] args){
	    @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    
		int n = Integer.parseInt(sc.nextLine());//总人数
		int ai = Integer.parseInt(sc.nextLine());//A的编号
		int m = Integer.parseInt(sc.nextLine());//相互认识的对数
		
		if(ai>=n) {
			System.out.println(0);
			return ;
		}
		
		@SuppressWarnings("unchecked")
		List<Integer>[] list = new ArrayList[n];
		
		for(int i = 0;i<n;i++) {
			list[i] = new ArrayList<Integer>();
		}
			
		boolean[] books = new boolean[n];
			
		for(int j = 0;j<m;j++){
			String msg = sc.nextLine();
			String[] ss = msg.split(",");
			int x = Integer.parseInt(ss[0]);
			int y = Integer.parseInt(ss[1]);
			if(x>=n||y>=n) {
			   continue;
			}
			list[x].add(y);
			list[y].add(x);
		}
			
		int[] ans = {0};
			
		int old = list[ai].size();
	    
		books[ai] = true;
			
		getCount(list, list[ai], books, ans);
			
		System.out.println(ans[0]-old);
	}
	
	public static int getCount(List<Integer>[] lists,List<Integer> list,boolean[] books,int[] an) {
		for(int i:list) {
			if(!books[i]) {
				an[0]++;
				books[i] = true;
				getCount(lists,lists[i], books, an);
			}
		}
		return an[0];
	}*/
	
	
	/*public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());//总人数
		int ai = Integer.parseInt(br.readLine());//A的编号
		int m = Integer.parseInt(br.readLine());//相互认识的对数
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
			
		for(int j = 0;j<m;j++){
			String[] ss = br.readLine().split(",");
			int x = Integer.parseInt(ss[0]);
			int y = Integer.parseInt(ss[1]);
			if(map.containsKey(x)) {
				map.get(x).add(y);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(y);
				map.put(x, list);
			}
			if(map.containsKey(y)) {
				map.get(y).add(x);
			}else {
				List<Integer> list = new ArrayList<Integer>();
				list.add(x);
				map.put(y, list);
			}
		}
			
		Set<Integer> books = new HashSet<Integer>();
		books.add(ai);
		
		List<Integer> res = new ArrayList<Integer>();
			
		Queue<Integer> que = new ArrayDeque<Integer>();
		que.offer(ai);
		
		while(!que.isEmpty()) {
			List<Integer> list = map.get(que.poll());
			for(int i = 0;i<list.size();i++) {
				if(!books.contains(list.get(i))) {
					res.add(list.get(i));
					books.add(list.get(i));
					que.offer(list.get(i));
				}
			}
		}
		
		System.out.println(res.size()-map.get(ai).size());
	}*/
	
	
	/*public static int[] father = new int[7];
	public static int[] vis = new int[7];
	public static int[] isRoot = new int[7];
	
	public static void init ()
	{
	    for (int i = 0; i < 7; i++)
	    {
	        father[i] = i;
	    }
	}
	
	public static int findFather (int son)//找son编号的顶级认识的人
	{
	    int t = son;
	    while (father[son] != son)
	    {
	        son = father[son];
	    }
	    while (father[t] != t)
	    {
	        int f = father[t];
	        father[t] = son;
	        t = f;
	    }
	    return son;
	}
	
	public static void union (int a, int b)
	{
	    int fa = findFather(a);
	    int fb = findFather(b);
	    if(fa != fb)
	        father[fa] = fb;
	}
	
	public static int findRoot (int a)
	{
	    for (int i = 0; i < 7; i++)
	    {
	        if(vis[i] == 1)
	        {
	            isRoot[findFather(i)]++;
	        }
	    }
	    int tar = findFather(a);
	    return isRoot[tar];
	}
	
	public static void main (String[] args) throws Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int ai = Integer.parseInt(br.readLine());
	    int m = Integer.parseInt(br.readLine());
	    init();
	    int count1 = 1;
	    for (int i = 0; i < m; i++)
	    {
	        String s = br.readLine();
	        String[] ss = s.split(",");
	        int a = Integer.parseInt(ss[0]), b = Integer.parseInt(ss[1]);
	        union(a, b);
	        vis[a] = vis[b] = 1;
	        if(a == ai || b == ai)
	            count1++;
	    }
	    
	    System.out.println(Arrays.toString(father));
	    int sum = findRoot(ai);
	    System.out.println(sum - count1);
	}*/
	
	static int[] father;
	static int[] vis;
	static int[] root;
	
	public static void main (String[] args) throws Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int ai = Integer.parseInt(br.readLine());
	    int m = Integer.parseInt(br.readLine());
	    
	    father = new int[n];
	    vis = new int[n];
	    root = new int[n];
	    
	    for(int i =0;i<n;i++) {
	    	father[i] = i;
	    	root[i] = 1;
	    }
	    
	    int count = 1;
	    for (int i = 0; i < m; i++)
	    {
	        String s = br.readLine();
	        String[] ss = s.split(",");
	        int a = Integer.parseInt(ss[0]), b = Integer.parseInt(ss[1]);
	        if(a>=0&&a<n&&b>=0&&b<n) {
		        union(a, b);
		        vis[a] = vis[b] = 1;
		        if(a == ai || b == ai)
		            count++;
	        }
	    }
	    getFather();
	    System.out.println(Arrays.toString(father));
	    System.out.println(Arrays.toString(root));
	    System.out.println(root[father[ai]] - count);
	}
	
	public static void union (int a, int b)
	{
	    int fa = father[a];
	    int fb = father[b];
	    if(fa != fb)
	        father[fa] = fb;
	}
	
	public static void getFather() {
		Set<Integer> set = new HashSet<Integer>();
		for(int i = 0;i<father.length;i++) {
			if(!set.contains(i)) {
				Deque<Integer> deq = new ArrayDeque<Integer>();
				int fa = i;
				while(father[fa] != fa) {
					deq.push(fa);
					fa = father[fa];
				}
				set.add(fa);
				while(!deq.isEmpty()) {
					int idx = deq.pop();
					father[idx] = fa;
					root[fa]++;
					set.add(idx);
				}
			}
		}
	}
}
/*
题目描述
小A参加了一个n人的活动，每个人都有一个唯一编号i(i>=0 & i<n)，其中m对相互认识，在活动中两个人可以通过互相都认识的一个人介绍认识。现在问活动结束后，小A最多会认识多少人？

输入描述:
第一行聚会的人数：n（n>=3 & n<10000）；
第二行小A的编号: ai（ai >= 0 & ai < n)；
第三互相认识的数目: m（m>=1 & m
< n(n-1)/2）；
第4到m+3行为互相认识的对，以','分割的编号。
输出描述:
输出小A最多会新认识的多少人？
示例1
输入
复制
7
5
6
1,0
3,1
4,1
5,3
6,1
6,5
输出
复制
3
*/
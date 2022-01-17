package leetcode.test0851to0900;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Leetcode851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
    	Map<Integer, Node> map = new HashMap<Integer, Node>();
    	
    	for(int i = 0; i < richer.length; i++) {
    		Node richNode = null;
    		Node poorNode = null;
    		
    		if(!map.containsKey(richer[i][0])) {
    			richNode = new Node(richer[i][0]);
    			map.put(richer[i][0], richNode);
    		}else {
    			richNode = map.get(richer[i][0]);
			}
    		
    		if(!map.containsKey(richer[i][1])) {
    			poorNode = new Node(richer[i][1]);
    			map.put(richer[i][1], poorNode);
    		}else {
    			poorNode = map.get(richer[i][1]);
			}
			richNode.poorSet.add(poorNode);
    	}
    	
    	int[] an = new int[quiet.length];
    	for(int i = 0; i < an.length; i++) {
    		an[i] = i;
    	}
    	
    	for(int rich: map.keySet()) {
    		Node riNode = map.get(rich);
    		Queue<Node> queue = new LinkedList<Node>();
    		addNode(queue, riNode.poorSet);
    		
    		while(!queue.isEmpty()) {
    			Node poorNode = queue.poll();
    			if(quiet[rich] < quiet[an[poorNode.person]]) {
    				an[poorNode.person] = rich;
    			}
    			addNode(queue, poorNode.poorSet);
    		}
    	}
    	
    	return an;
    }
    
    public void addNode(Queue<Node> queue, Set<Node> poorSet) {
		for(Node node: poorSet) {
			queue.offer(node);
		}
	}
    class Node{
    	public int person;
    	public Set<Node> poorSet = new HashSet<Node>();
    	
    	public Node(int person) {
    		this.person = person;
    	}

    	@Override
    	public int hashCode() {
    		final int prime = 31;
    		int result = 1;
    		result = prime * result + person;
    		return result;
    	}

    	@Override
    	public boolean equals(Object obj) {
    		if (this == obj)
    			return true;
    		if (obj == null)
    			return false;
    		if (getClass() != obj.getClass())
    			return false;
    		Node other = (Node) obj;
    		
    		if (this.person != other.person)
    			return false;
    		return true;
    	}
    }
    
}


/*
有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为 x 的人简称为 "person x "。

给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。另给你一个整数数组 quiet ，其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自恰（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。

现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。

 

示例 1：

输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
输出：[5,5,2,5,4,5,6,7]
解释： 
answer[0] = 5，
person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
但是目前还不清楚他是否比 person 0 更有钱。
answer[7] = 7，
在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
最安静（有较低安静值 quiet[x]）的人是 person 7。
其他的答案也可以用类似的推理来解释。
示例 2：

输入：richer = [], quiet = [0]
输出：[0]
 
提示：

n == quiet.length
1 <= n <= 500
0 <= quiet[i] < n
quiet 的所有值 互不相同
0 <= richer.length <= n * (n - 1) / 2
0 <= ai, bi < n
ai != bi
richer 中的所有数对 互不相同
对 richer 的观察在逻辑上是一致的

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/loud-and-rich
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
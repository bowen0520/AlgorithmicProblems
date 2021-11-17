package leetcode.test0201to0250;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode212 {
	class Node{
		public int x;
		public int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
    public List<String> findWords(char[][] board, String[] words) {
    	Map<Character, List<Node>> map = new HashMap<Character, List<Node>>();
    	
    	for(int i = 0; i < board.length; i++) {
    		for(int j = 0; j < board[0].length; j++) {
    			char c = board[i][j];
    			if(map.containsKey(c)) {
    				map.get(c).add(new Node(i, j));
    			}else {
					List<Node> list = new ArrayList<Node>();
					list.add(new Node(i, j));
					map.put(c, list);
				}
    		}
    	}
    	List<String> anList = new ArrayList<String>();
    	boolean[][] book = new boolean[board.length][board[0].length];
    	for(String s: words) {
    		char[] cs = s.toCharArray();
    		
    		if(map.containsKey(cs[0])) {
    			boolean flag = false;
    	    	for(Node node: map.get(cs[0])) {
		    		book[node.x][node.y] = true;
		    		flag = findWords(map, cs, 1, book, node);
		    		book[node.x][node.y] = false;
    	    		if(flag) {
    	    			anList.add(s);
    	    			break;
    	    		}
    	    	}
        	}
    	}
    	
    	return anList;
    }
    
    public boolean findWords(Map<Character, List<Node>> map, char[] cs, int index, boolean[][] book, Node lastNode) {
    	if(index >= cs.length) {
    		return true;
    	}
    	boolean flag = false;
    	
    	if(map.containsKey(cs[index])) {
	    	for(Node node: map.get(cs[index])) {
	    		if(!book[node.x][node.y] && checkNiber(node, lastNode)) {
		    		book[node.x][node.y] = true;
		    		flag = findWords(map, cs, index + 1, book, node);
		    		book[node.x][node.y] = false;
	    		}
	    		if(flag) {
	    			return true;
	    		}
	    	}
    	}
    	return flag;
    }
    
    public boolean checkNiber(Node node, Node lastNode) {
    	if(node.x == lastNode.x) {
    		if(node.y == lastNode.y + 1 || node.y == lastNode.y - 1) {
    			return true;
    		}
    	} else if(node.y == lastNode.y) {
    		if(node.x == lastNode.x + 1 || node.x == lastNode.x - 1) {
    			return true;
    		}
    	}
    	
    	return false;
    }
}

/*
给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。

单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。

 

示例 1：


输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
输出：["eat","oath"]
示例 2：


输入：board = [["a","b"],["c","d"]], words = ["abcb"]
输出：[]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/word-search-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
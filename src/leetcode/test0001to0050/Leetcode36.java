package leetcode.test0001to0050;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode36 {
    public boolean isValidSudoku(char[][] board) {
        Map<Character, Set<String>> map = new HashMap<Character, Set<String>>();
        
        for(int i = 0;i<board.length;i++) {
        	for(int j = 0;j<board[0].length;j++) {
        		if(board[i][j]!='.') {
        			String[] books = getBook(i, j);
        			
        			if(map.containsKey(board[i][j])) {
        				for(String book:books) {
	        				if(map.get(board[i][j]).contains(book)) {
	        					return false;
	        				}
	        				map.get(board[i][j]).add(book);
        				}
        			}else {
        				Set<String> set = new HashSet<String>();
        				set.add(books[0]);
        				set.add(books[1]);
        				set.add(books[2]);
        				map.put(board[i][j],set);
        			}
        		}
        	}
        }
        
        return true;
    }
    
    public String[] getBook(int x,int y) {
    	String[] ls = new String[3];
    	ls[0] = "h"+x;
    	ls[1] = "l"+y;
    	int z = (x/3)*3+y/3;
    	ls[2] = "k"+z;
    	return ls;
    }
}
/*
判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。


上图是一个部分填充的有效的数独。

数独部分空格内已填入了数字，空白格用 '.' 表示。

示例 1:

输入:
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: true
示例 2:

输入:
[
  ["8","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
输出: false
解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
说明:

一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
给定数独序列只包含数字 1-9 和字符 '.' 。
给定数独永远是 9x9 形式的。
*/
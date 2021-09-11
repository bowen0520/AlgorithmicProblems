package leetcode.test1001to1050;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Leetcode1047 {
	/*
	 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

在 S 上反复执行重复项删除操作，直到无法继续删除。

在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

 

示例：

输入："abbaca"
输出："ca"
解释：
例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。

	 */
    public String removeDuplicates(String S) {
        Deque<Character> deque = new LinkedList<Character>();
        
        char com = '0';
        for(char c: S.toCharArray()) {
        	if(deque.size() != 0 && c == deque.peek()) {
        		deque.pop();
        	}else {
				deque.push(c);
			}
        	
        }
        
        String s = new String();
        while (deque.size() != 0) {
			s = deque.pop() + s;
		}
        
        return s;
    }
    
    
    public boolean isValidSerialization(String preorder) {
        String[] ssStrings = preorder.split(",");
        if(ssStrings.length <= 1) {
        	return true;
        }
        int n = 2;
        
        if(ssStrings[0].equals("#")) {
        	return false;
        }
        
        for(int i = 1; i< ssStrings.length;i++) {
        	if(ssStrings[i].equals("#")) {
        		if(n < 1) {
        			return false;
        		}
        		n--;
        	}else {
				n++;
			}
        }
        return n==0;
    }
}

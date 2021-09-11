package leetcode.test0001to0050;

import java.util.Deque;
import java.util.LinkedList;

import leetcode.referenceclass.ListNode;

public class Leetcode22J {
    public ListNode getKthFromEnd(ListNode head, int k) {
    	ListNode tempListNode = head;
        for(int i = 0; i < k; i++ ) {
        	if(tempListNode.next == null) {
        		return null;
        	}
        	tempListNode = tempListNode.next;
        	
        }
        
        while(tempListNode.next != null) {
        	head = head.next;
        	tempListNode = tempListNode.next;
        }
        
        return head;
    }
    
    public static void main(String[] args) {
		String string = "{(})";
		
		System.out.println(checkClose(string));
	}
    
    
	public static boolean checkClose(String str){
		char[] cs = str.toCharArray();

		Deque<Character> deq = new LinkedList<Character>();

		for(char c: cs){
			if(c == '(' || c == '{' || c == '['){
				deq.push(c);
			}
			
			if(c == ')' || c == '}' || c == ']'){
				char ctemp = 'a';
				if(!deq.isEmpty()) {
					ctemp = deq.pop();
				}else {
					return false;
				}
				if(c == ')' && ctemp != '('){
					return false;
				}

				if(c == '}' && ctemp != '{'){
					return false;
				}

				if(c == ']' && ctemp != '['){
					return false;
				}
			}
		}

		return deq.isEmpty();
	}
}

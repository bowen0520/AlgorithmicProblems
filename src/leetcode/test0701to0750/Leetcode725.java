package leetcode.test0701to0750;

import leetcode.referenceclass.ListNode;

public class Leetcode725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] an = new ListNode[k];
        
        int len = 0;
        ListNode tmpListNode = head;
        while(tmpListNode != null) {
        	len++;
        	tmpListNode = tmpListNode.next;
        }
        
        int jL = len/k;
        int yL = len%k;
        
        for(int j = 0; j < k; j++) {
			int newL = jL + (yL > 0 ? 1 : 0);
			tmpListNode = head;
			an[j] = tmpListNode;
			for(int i = 0; i < newL - 1; i++) {
				head = head.next;
			}
			if(head != null){
                ListNode tmp = head;
                head = head.next;
                tmp.next = null;
            }
			yL--;
		}
        
        return an;
    }
}

package pointoffer;

import pointoffer.referenceclass.ListNode;

public class Offer36 {
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		 int count1 = 0;
		 ListNode head1 = pHead1;
		 while(head1!=null) {
			 count1++;
			 head1 = head1.next;
		 }
		 
		 int count2 = 0;
		 ListNode head2 = pHead2;
		 while(head2!=null) {
			 count2++;
			 head2 = head2.next;
		 }
		 
		 int c = Math.abs(count2-count1);
		 ListNode s = count1>count2?pHead2:pHead1;
		 ListNode l = count1<=count2?pHead2:pHead1;
		 
		 while(s!=l) {
			 if(c<=0) {
				 s = s.next;
			 }
			 l = l.next;
			 c--;
		 }
		 return s;
    }
	
	/*
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
	    if(pHead1==null||pHead2==null){
	        return null;
	    }
	    ListNode h1 = pHead1;
	    while(h1!=null){
	        ListNode h2 = pHead2;
	        while(h2!=null){
	            if(h2 == h1){
	                return h2;
	            }
	            h2 = h2.next;
	        }
	        h1 = h1.next;
	    }
	    return null;
	}*/
}
/*
题目描述
输入两个链表，找出它们的第一个公共结点。
*/
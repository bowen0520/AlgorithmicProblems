package pointoffer;

import java.util.HashSet;

import pointoffer.referenceclass.ListNode;

public class Offer55 {
	public ListNode EntryNodeOfLoop(ListNode pHead){
		if(pHead==null){
            return null;
        }
        HashSet<ListNode> set = new HashSet<ListNode>();
        set.add(pHead);
        while(pHead.next!=null&&set.add(pHead.next)){
            pHead = pHead.next;
        }
        if(pHead.next==null){
            return null;
        }
        return pHead.next;
    }
}
/*
题目描述
给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
*/
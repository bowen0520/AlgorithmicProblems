package pointoffer;

import java.util.HashMap;

import pointoffer.referenceclass.ListNode;

public class Offer56 {
	public ListNode deleteDuplication(ListNode pHead){
		/*if(pHead==null){
		    return pHead;
		}
		ListNode p = pHead;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while(p!=null){
		    if(map.containsKey(p.val)){
		        map.put(p.val, map.get(p.val)+1);
		    }else{
		        map.put(p.val, 1);
		    }
		    p = p.next;
		}
		while(pHead!=null&&map.get(pHead.val)>1){
		    pHead = pHead.next;
		}
		p = pHead;
		while(p!=null&&p.next!=null){
		    if(map.get(p.next.val)>1){
		        p.next = p.next.next;
		    }else{
		        p = p.next;
		    }
		}
		return pHead;*/
		
		if(pHead==null||pHead.next==null){
            return pHead;
        }
        ListNode p = new ListNode(-1);
        p.next = pHead;
        ListNode temp = p;
        while(temp!=null&&temp.next!=null&&temp.next.next!=null){
            if(temp.next.val!=temp.next.next.val){
                temp = temp.next;
            }else{
                int v = temp.next.val;
                while(temp.next!=null&&temp.next.val==v){
                    temp.next = temp.next.next;
                }
            }
        }
        return p.next;
    }
}
/*
在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
*/
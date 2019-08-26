package pointoffer;

import pointoffer.referenceclass.RandomListNode;

public class Offer25 {
	/*public RandomListNode Clone(RandomListNode pHead){
		RandomListNode head = null;
	    if(pHead==null) {
	    	return head;
	    }
	    head = pHead;
	    while(head!=null) {
	    	RandomListNode node = new RandomListNode(head.label);
	    	RandomListNode temp = head.next;
	    	head.next = node;
	    	node.next = temp;
	    	head = temp;
	    }
	    head = pHead;
	    while(head!=null) {
	    	if(head.random!=null) {
	    		head.next.random = head.random.next;
	    	}
	    	head = head.next.next;
	    }
	    RandomListNode clone = pHead.next;
	    while(pHead!=null) {
	    	head = pHead.next;
	    	pHead.next = head.next;
	    	head.next = pHead.next==null?null:pHead.next.next;
	    	pHead = pHead.next;
	    }
	    return clone;
	}*/
	
	//暴力，没有上面的好
	public RandomListNode Clone(RandomListNode pHead){
        if(pHead==null){
            return null;
        }
        RandomListNode head = new RandomListNode(pHead.label);
        RandomListNode pTemp = pHead;
        RandomListNode temp = head;
        while(pTemp.next!=null){
            temp.next = new RandomListNode(pTemp.next.label);
            pTemp = pTemp.next;
            temp = temp.next;
        }
        pTemp = pHead;
        temp = head;
        while(temp!=null){
            temp.random = FindRandom(head, pHead, pTemp);
            temp = temp.next;
            pTemp = pTemp.next;
        }
        return head;
    }
	
    public RandomListNode FindRandom(RandomListNode head,RandomListNode pHead,RandomListNode pTemp){   
    	if(pTemp.random!=null){
            while(pHead!=null){
                if(pHead==pTemp.random){
                    return head;
                }
                pHead = pHead.next;
                head = head.next;
            }
        }
        return null;
    }
}
/*
题目描述
输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
*/
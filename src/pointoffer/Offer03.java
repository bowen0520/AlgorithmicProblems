package pointoffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

import pointoffer.referenceclass.ListNode;

public class Offer03 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        while(listNode!=null) {
        	deque.push(listNode.val);
        	listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        //deque.forEach((o)->list.add(o));
        while(!deque.isEmpty()) {
        	list.add(deque.pop());
        }
        return list;
    }
}
/*
 * 题目描述 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
package leetcode.test0151to0200;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Leetcode155 {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());   //--> 返回 -3.
		minStack.pop();
		System.out.println(minStack.top());      //--> 返回 0.
		System.out.println(minStack.getMin());   //--> 返回 -2.
	}
}

class MinStack {
	//private Deque<Integer> deq;
	//private Deque<Integer> min;
	Stack<Integer> deq;
	Stack<Integer> min;
	
    /** initialize your data structure here. */
    public MinStack() {
    	//deq = new LinkedList<Integer>();
    	//min = new LinkedList<Integer>();
    	//deq = new ArrayDeque<Integer>();
    	//min = new ArrayDeque<Integer>();
    	deq = new Stack<Integer>();
    	min = new Stack<Integer>();
    	min.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        deq.push(x);
        if(x<min.peek()) {
        	min.push(x);
        }else {
        	min.push(min.peek());
        }
    }
    
    public void pop() {
        deq.pop();
        min.pop();
    }
    
    public int top() {
        return deq.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}

/*
设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) -- 将元素 x 推入栈中。
pop() -- 删除栈顶的元素。
top() -- 获取栈顶元素。
getMin() -- 检索栈中的最小元素。
示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
*/
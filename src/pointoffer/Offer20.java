package pointoffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Offer20 {
	/*List<Integer> nums = new ArrayList<Integer>();
	List<Integer> mins = new ArrayList<Integer>();
	int min = Integer.MAX_VALUE;
	int size = 0;
	public void push(int node) {
	    nums.add(node);
	    if(node<min) {
	    	min = node;
	    }
	    mins.add(min);
	    size++;
	}
	
	public void pop() {
	    if(size==0) {
	    	return ;
	    }
	    nums.remove(size-1);
	    mins.remove(size-1);
	    size--;
	    min = mins.get(size-1)
	}
	
	public int top() {
		if(size == 0) {
			return -1;
		}
	    return nums.get(size-1);
	}
	
	public int min() {
		if(size == 0) {
			return -1;
		}
	    return mins.get(size-1);
	}*/
	
	Stack<Integer> nums = new Stack<Integer>();
    Stack<Integer> mins = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        nums.push(node);
        if(node<min){
            min = node;
        }
        mins.push(min);
    }
     
    public void pop() {
        nums.pop();
        mins.pop();
        min = mins.peek();
    }
     
    public int top() {
        return nums.peek();
    }
     
    public int min() {
        return mins.peek();
    }
}
/*
 * 题目描述 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */